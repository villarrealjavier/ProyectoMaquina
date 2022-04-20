package main.java.model;

import java.util.HashMap;
import java.util.Map;

public class Monedero {
	private Map<Moneda, Integer> cantidades;
	private static final Integer CANTIDAD=50;
	public Monedero() {
		cantidades = new HashMap<Moneda, Integer>();
		inicializarMonedero();
	}

	public void inicializarMonedero() {
		cantidades.put(Moneda.FIVECENT, CANTIDAD);
		cantidades.put(Moneda.TENCENT, CANTIDAD);
		cantidades.put(Moneda.TWENTYCENT, CANTIDAD);
		cantidades.put(Moneda.FITTYCENT, CANTIDAD);
		cantidades.put(Moneda.ONEEURO, CANTIDAD);
		cantidades.put(Moneda.TWOEURO, CANTIDAD);

	}
	
	public Map<Moneda, Integer> calcularCambio(Map<Moneda, Integer> pago, Integer precio){
		Map<Moneda, Integer> cambio = new HashMap<Moneda, Integer>();
		Integer dineroApagar=calcularPago(pago);
		if (dineroApagar>=precio) {
			dineroApagar=dineroApagar-precio;
			while(dineroApagar>=Moneda.TENCENT.value) {
			if ((dineroApagar)>= Moneda.TWOEURO.value) {
				cambio.put(Moneda.TWOEURO, 1);
				dineroApagar=dineroApagar-Moneda.TWOEURO.value;		
			}else if ((dineroApagar)>=Moneda.ONEEURO.value) {
				cambio.put(Moneda.ONEEURO, 1);
				dineroApagar=dineroApagar-Moneda.ONEEURO.value;	
			}else if ((dineroApagar)>=Moneda.FITTYCENT.value) {
				cambio.put(Moneda.FITTYCENT,1);
				dineroApagar=dineroApagar-Moneda.FITTYCENT.value;	
				
			}else if ((dineroApagar)>=Moneda.TWENTYCENT.value) {
				cambio.put(Moneda.TWENTYCENT,1);
				dineroApagar=dineroApagar-Moneda.TWENTYCENT.value;
			}else if((dineroApagar)>=Moneda.TENCENT.value) {
				cambio.put(Moneda.TENCENT,1);
				dineroApagar=dineroApagar-Moneda.TENCENT.value;
			}
			}
		}
		return cambio;
		
	}
	
	public Integer calcularPago(Map<Moneda, Integer> pago) {
		Integer cantidad=0;
		for (Moneda m: pago.keySet()) {
			cantidad+=pago.get(m)*m.value;
		}
		return cantidad;
		
	}
}
