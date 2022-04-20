package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cafe {
	private String marca;
	private String tipo;
	
	
	public Cafe() {
		// TODO Auto-generated constructor stub
	}
	public Cafe(String marca) {
		this.marca=marca;


	}
	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//TOSTRING
	@Override
	public String toString() {
		return "Cafe marca=" + marca + ", tipo=" + "tipo";
	}
	//HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(marca, tipo);
	}
	//EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cafe other = (Cafe) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(tipo, other.tipo);
	}
	
	


	
}
