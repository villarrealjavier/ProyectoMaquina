package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.model.MaquinaCafe;
import main.java.model.Moneda;
import main.java.model.Monedero;

class CafeTest {

	@Test
	void test() {
		Monedero mon = new Monedero();
		
		Map<Moneda, Integer> pago = new HashMap<>();
		pago.put(Moneda.TWOEURO, 2);
		pago.put(Moneda.FITTYCENT, 1);

		
		
		
		assertEquals(mon.calcularPago(pago), 450);
	}
	@Test
	void testCambio() {
		Monedero mon = new Monedero();
		Map<Moneda, Integer> cambio = new HashMap<>();
		cambio.put(Moneda.FITTYCENT, 1);
		cambio.put(Moneda.TENCENT, 1);
		Map<Moneda, Integer> cambio2 = new HashMap<>();
		cambio2.put(Moneda.FITTYCENT, 1);
		cambio2.put(Moneda.TWENTYCENT, 1);
		cambio2.put(Moneda.TENCENT, 1);



		
		Map<Moneda, Integer> pago = new HashMap<>();
		pago.put(Moneda.ONEEURO, 1);
		pago.put(Moneda.TENCENT, 1);
		Map<Moneda, Integer> pago2 = new HashMap<>();
		pago2.put(Moneda.ONEEURO, 1);
		pago2.put(Moneda.TWENTYCENT, 1);
		pago2.put(Moneda.TENCENT , 1);



		
		assertEquals(mon.calcularCambio(pago,50),cambio);
		assertEquals(mon.calcularCambio(pago2,50),cambio2);
		

	}
	
	@Test
	void testListaVacia() {
		Monedero mon = new Monedero();
		Map<Moneda, Integer> pago = new HashMap<>();
		Map<Moneda, Integer> listaVacia = new HashMap<>();
		
		assertEquals(mon.calcularCambio(pago,100),listaVacia);

		
	}
	@Test
	void testListaNula() {
		Monedero mon = new Monedero();
		Map<Moneda, Integer> pago = new HashMap<>();
		Map<Moneda, Integer> listaVacia = new HashMap<>();
		pago=null;
		
		assertEquals(mon.calcularCambio(pago,100),listaVacia);
	}
	@Test
	void servirCafesinDineroTest() {
		Map<Moneda, Integer> pago = new HashMap<>();
		pago.put(Moneda.FIVECENT, 1);
		MaquinaCafe primercafe = new MaquinaCafe();
		

		assertEquals(primercafe.servirCafe(pago),"No se pudo servir el café");

		
	}
	@Test
	void llenarDepositosTest() {
		MaquinaCafe c1= new MaquinaCafe(1, 1);
		c1.llenarDepositos();

		assertEquals(c1.getDepositoCafe(),50);
		assertEquals(c1.getDepositoVasos(),80);


		
	}
	@Test
	void annadirAlHistoriaTest() {
		MaquinaCafe c1= new MaquinaCafe(1, 1);
		c1.addCafe("Nesspreso");

		assertEquals(c1.getHistorial().size(),1);
		
	}


}
