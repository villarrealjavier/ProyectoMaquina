package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MaquinaCafe {
	
	private int depositoCafe=50;
	private int depositoLeche=50;
	private int depositoVasos=80;
	private List<Cafe> historial = new ArrayList<Cafe>();
	
	
	

	private double monedero=0;
	private double saldo;
	private double cambio=30;
	
	
	//CONSTRUCTORES
	public MaquinaCafe(){
		
	}
	public MaquinaCafe(double saldo) {
		this.saldo=saldo;
	}
	
	
	//METODOS
	public void servirCafe() {
		Scanner sc = new Scanner(System.in);
		double precioCafe=1;
		String resultado="";
		if (saldo>=precioCafe) {
			System.out.println("Introduce la marca de cafe (Nesspreso, Saimaza): ");
			String marca = sc.nextLine();
			if (marca!=null) {
				Cafe c1 = new Cafe(marca);
				this.historial.add(c1);
				System.out.println("Producto Servido");
				setSaldo(saldo-precioCafe);
				depositoCafe--;
			}
			
			
			setMonedero(getMonedero()+precioCafe);
		}else {
			resultado="No es posible asignar el producto";
		} 
		
	}
	public void addCafe(String marca) {
		if (marca!=null && (!marca.isEmpty())) {
			this.historial.add(new Cafe(marca));
		}else {
			throw new CafeExeption ("No se ha podido a�adir el cafe");
		}
	}
	
	public String servirLeche() {
		double precioLeche=0.80;
		String resultado="";
		if (saldo>=precioLeche) {
			resultado="Producto Servido";
			setSaldo(saldo-precioLeche);
			depositoLeche--;
			setMonedero(getMonedero()+precioLeche);
		}else {
			resultado="No es posible asignar el producto";
	}
		return resultado;
	}
	
	public void annadirCafeLista(Cafe cf1) {
		if (cf1!=null) {
			historial.add(cf1);
		}
		
		
	}
	public String servirCafeLeche() {
		double precioCafeLeche=1.50;
		String resultado="";
		if (saldo>=precioCafeLeche) {
			resultado="Producto Servido";
			setSaldo(saldo-precioCafeLeche);
			depositoVasos--;
			setMonedero(getMonedero()+precioCafeLeche);
		}else {
			resultado="No es posible asignar el producto";
	}
		return resultado;
	}
	public void llenarDepositos() {
		if (getDepositoCafe()<=0 || getDepositoLeche()<=50 || getDepositoVasos()<=0) {
			setDepositoCafe(50);
			setDepositoLeche(50);
			setDepositoVasos(80);
		}
		
	}
	public String vaciarMonedero() {
		if (getMonedero()>=0.1) {
			setMonedero(0.0);
			
		}return "El monedero ha sido vaciado.";
		
	}
	
	
	
	
	//GETTERS AND SETTERS
	public int getDepositoCafe() {
		return depositoCafe;
	}
	public void setDepositoCafe(int depositoCafe) {
		this.depositoCafe = depositoCafe;
	}
	public int getDepositoLeche() {
		return depositoLeche;
	}
	public void setDepositoLeche(int depositoLeche) {
		this.depositoLeche = depositoLeche;
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
	public int getLeche() {
		return depositoLeche;
	}
	public void setLeche(int leche) {
		this.depositoLeche = leche;
	}
	public int getVasos() {
		return depositoVasos;
	}
	public void setVasos(int vasos) {
		this.depositoVasos = vasos;
	}
	public double getMonedero() {
		return monedero;
	}
	public void setMonedero(double monedero) {
		this.monedero = monedero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		double precioCafe=1;
		double precioLeche=0.80;
		double precioCafeLeche=1.50;
		if (saldo>=precioCafe || saldo>=precioLeche || saldo>=precioCafeLeche) {
			this.saldo = saldo;
		}else {
			
			throw new CafeExeption("No es valido.");
			
		}
		
	}
	public double getCambio() {
		return cambio;
	}
	public void setCambio(double cambio) {
		this.cambio = cambio;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("El estado del deposito de Vasos de de: \n ");
		sb.append(getVasos()+"\n");
		sb.append("El estado del deposito de Cafe de de: \n ");
		sb.append(getDepositoCafe()+"\n");
		sb.append("El estado del deposito de Leche de: \n ");
		sb.append(getDepositoLeche()+"\n");
		sb.append("Su monedero actual es de: \n");
		sb.append(getMonedero()+"\n");
		return sb.toString();
		
	}
	
	
	

}
