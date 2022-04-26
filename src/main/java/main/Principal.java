package main.java.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import main.java.model.MaquinaCafe;
import main.java.model.Moneda;
import main.java.model.Monedero;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean bucle =true;
		MaquinaCafe primercafe = new MaquinaCafe();
		Monedero monedero = new Monedero();
		Map<Moneda, Integer> pago = new HashMap<>();
		pago.put(Moneda.TWOEURO, 1);
		try {
			
			System.out.println("Introduce el dinero con el que desea pagar: ");
			//primercafe.setSaldo(Double.valueOf(sc.nextLine()));
			while(bucle==true) {
			System.out.println("Seleccione una de las siguientes opciones: ");
			System.out.println("1.Servir cafe solo (1 euro)");
			System.out.println("2. Calcular valor total. ");
			System.out.println("3. Consultar Historial");
			System.out.println("4. Apagar máquina, y salir");

			

			
			int opcion =(Integer.valueOf(sc.nextLine()));
			if (opcion==1) {
				System.out.println(primercafe.servirCafe(pago));
				pago=monedero.calcularCambio(pago, primercafe.getPrecioCafe());
		
				
			}else if (opcion==2) {
				System.out.println(monedero.calcularPago(pago));
				
			}else if (opcion==3) {
				System.out.println(primercafe.getHistorial());

				
			}else if (opcion==4) {
				bucle=false;

			}

			
		}
			
		}catch(Exception errorMaquinaCafe){
			System.out.println("Se ha producido una excepcion:"+ errorMaquinaCafe.getMessage());
			
		}
		
		
		
		
		
		
		
	}
	
	
	


}
