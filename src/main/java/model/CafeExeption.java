package main.java.model;

public class CafeExeption extends RuntimeException {
	public CafeExeption(String mensaje) {
		super(mensaje);
		getMessage();
	}
}
