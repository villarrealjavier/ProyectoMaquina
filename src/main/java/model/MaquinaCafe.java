package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MaquinaCafe {
	
	private int depositoCafe=50;
	private int depositoVasos=80;
	private List<Cafe> historial = new ArrayList<Cafe>();
	private Monedero monedero = new Monedero();
	private Integer precioCafe=100;    //EN CENTIMOS
	
	
	//CONSTRUCTORES
	public MaquinaCafe(){

	}
	public MaquinaCafe(int depositoCafe, int DepositoVasos){
		this.depositoCafe=depositoCafe;
		this.depositoVasos=depositoVasos;
	}

	
	
	//METODOS
	public String servirCafe(Map<Moneda, Integer> pago) {
		
		String resultado="";
		
		if(monedero.calcularPago(pago)>precioCafe) {
			if (depositoCafe==1 || depositoVasos==1) {
				Cafe c1 = new Cafe();
				historial.add(c1);
				llenarDepositos();
				monedero.calcularCambio(pago, precioCafe);
				pago=monedero.calcularCambio(pago, precioCafe);
				depositoCafe--;
				depositoVasos--;
				resultado="Cafe Servido";

			}else {
				Cafe c1 = new Cafe();
				historial.add(c1);
				monedero.calcularCambio(pago, precioCafe);
				depositoCafe--;
				depositoVasos--;
				pago=monedero.calcularCambio(pago, precioCafe);

				resultado="Cafe Servido";
			}
		}else {
			resultado="No se pudo servir el café";

		}
		
		
		return resultado;
		
	}
	
	public void addCafe(String marca) {
		if (marca!=null && (!marca.isEmpty())) {
			this.historial.add(new Cafe(marca));
		}else {
			throw new CafeExeption ("No se ha podido añadir el cafe");
		}
	}
	
	
	
	public  void annadirCafeLista(Cafe cf1) {
		if (cf1!=null) {
			historial.add(cf1);
		}
		
		
	}
	
	public void llenarDepositos() {
		if (getDepositoCafe()<=1 || getDepositoVasos()<=1) {
			setDepositoCafe(50);
			setDepositoVasos(80);
		}
		
	}
		
	
	
	
	
	
	//GETTERS AND SETTERS
	public int getDepositoCafe() {
		return depositoCafe;
	}
	public Integer getPrecioCafe() {
		return precioCafe;
	}



	public void setPrecioCafe(Integer precioCafe) {
		this.precioCafe = precioCafe;
	}



	public void setDepositoCafe(int depositoCafe) {
		this.depositoCafe = depositoCafe;
	}

	public int getDepositoVasos() {
		return depositoVasos;
	}
	public void setDepositoVasos(int depositoVasos) {
		this.depositoVasos = depositoVasos;
	}
	public int getCafe() {
		return depositoCafe;
	}
	public void setCafe(int cafe) {
		this.depositoCafe = cafe;
	}
	public List<Cafe> getHistorial() {
		return historial;
	}
	public void setHistorial(List<Cafe> historial) {
		this.historial = historial;
	}

	public int getVasos() {
		return depositoVasos;
	}
	public void setVasos(int vasos) {
		this.depositoVasos = vasos;
	}

	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("El estado del deposito de Vasos de de: \n ");
		sb.append(getVasos()+"\n");
		sb.append("El estado del deposito de Cafe de de: \n ");
		sb.append(getDepositoCafe()+"\n");
		sb.append("Su monedero actual es de: \n");
		return sb.toString();
		
	}
	
	
	

}
