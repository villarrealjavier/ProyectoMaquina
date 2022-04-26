package main.java.model;

import java.util.HashMap;
import java.util.Map;

public class Monedero {
	private Map<Moneda, Integer> monedero;
	private static Integer CANTIDAD=1;
	
	public Monedero() {
		monedero = new HashMap<Moneda, Integer>();
		inicializarMonedero();
	}

	public void inicializarMonedero() {
		monedero.put(Moneda.FIVECENT, CANTIDAD);
		monedero.put(Moneda.TENCENT, CANTIDAD);
		monedero.put(Moneda.TWENTYCENT, CANTIDAD);
		monedero.put(Moneda.FITTYCENT, CANTIDAD);
		monedero.put(Moneda.ONEEURO, CANTIDAD);
		monedero.put(Moneda.TWOEURO, CANTIDAD);

	}
	
	public Map<Moneda, Integer> calcularCambio(Map<Moneda, Integer> pago, Integer precio){
		Map<Moneda, Integer> cambio = new HashMap<Moneda, Integer>();
		
		if(pago!=null) {
			Integer dineroApagar=calcularPago(pago);
			if (dineroApagar>=precio) {
				dineroApagar=dineroApagar-precio;
				for (Moneda m:monedero.keySet()) {
					if (monedero.get(m)==1) {
						monedero.put(m, CANTIDAD);
					}
				}
				
				while(dineroApagar>=Moneda.TENCENT.value) {
				if ((dineroApagar)>= Moneda.TWOEURO.value) {
					cambio.put(Moneda.TWOEURO, 1);
					dineroApagar=dineroApagar-Moneda.TWOEURO.value;	
					monedero.put(Moneda.TWOEURO, monedero.get(Moneda.TWOEURO)-1);
				}else if ((dineroApagar)>=Moneda.ONEEURO.value) {
					cambio.put(Moneda.ONEEURO, 1);
					dineroApagar=dineroApagar-Moneda.ONEEURO.value;
					monedero.put(Moneda.ONEEURO, monedero.get(Moneda.ONEEURO)-1);
				}else if ((dineroApagar)>=Moneda.FITTYCENT.value) {
					cambio.put(Moneda.FITTYCENT,1);
					dineroApagar=dineroApagar-Moneda.FITTYCENT.value;	
					monedero.put(Moneda.FITTYCENT, monedero.get(Moneda.FITTYCENT)-1);
				}else if ((dineroApagar)>=Moneda.TWENTYCENT.value) {
					cambio.put(Moneda.TWENTYCENT,1);
					dineroApagar=dineroApagar-Moneda.TWENTYCENT.value;
					monedero.put(Moneda.TWENTYCENT, monedero.get(Moneda.TWENTYCENT)-1);
				}else if((dineroApagar)>=Moneda.TENCENT.value) {
					cambio.put(Moneda.TENCENT,1);
					dineroApagar=dineroApagar-Moneda.TENCENT.value;
					monedero.put(Moneda.TENCENT, monedero.get(Moneda.TENCENT)-1);
				}
				}
			}
		}
		
		return cambio;
		}
		
	

	
	public Integer calcularPago(Map<Moneda, Integer> dinero) {
		Integer cantidad=0;
		for (Moneda m: dinero.keySet()) {
			cantidad+=dinero.get(m)*m.value;
		}
		return cantidad;
		
	}

	public Map<Moneda, Integer> getMonedero() {
		return monedero;
	}

	public void setMonedero(Map<Moneda, Integer> monedero) {
		this.monedero = monedero;
	}

	public static Integer getCantidad() {
		return CANTIDAD;
	}
}
