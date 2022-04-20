package main.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

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
		cambio.put(Moneda.TWOEURO, 1);
		cambio.put(Moneda.ONEEURO, 1);
		cambio.put(Moneda.FITTYCENT, 1);

		
		Map<Moneda, Integer> pago = new HashMap<>();
		pago.put(Moneda.ONEEURO, 4);

		
		
		
		assertEquals(mon.calcularCambio(pago,50),cambio);
	}


}
