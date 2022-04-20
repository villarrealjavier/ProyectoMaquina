package main.java.main;

import java.util.Iterator;
import java.util.Scanner;

import main.java.model.MaquinaCafe;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean bucle =true;
		MaquinaCafe primercafe = new MaquinaCafe();
		try {
			
			System.out.println("Introduce el dinero con el que desea pagar: ");
			primercafe.setSaldo(Double.valueOf(sc.nextLine()));
			while(bucle==true) {
			System.out.println("Seleccione una de las siguientes opciones: ");
			System.out.println("1.Servir cafe solo (1 euro)");
			System.out.println("2. Servir cafe con leche (1,5 euros)");
			System.out.println("3. Servir cafe bombon (1,5 euros)");
			System.out.println("4. Consultar estado máquina. Aparecen los datos de los depósitos y del\n"
					+ "monedero");
			System.out.println("5. Consultar historial");
			
			System.out.println("6. Apagar máquina, y salir");
			
			int opcion =(Integer.valueOf(sc.nextLine()));
			if (opcion==1) {
				primercafe.servirCafe();
				
			}else if (opcion==2) {
				
				
			}else if (opcion==3) {
				
				
			}else if (opcion==4) {
				
			}else if (opcion==5) {
					System.out.println(primercafe.getHistorial());
				
			}

			else if (opcion==6) {
				bucle=false;
	
			}
		}
			
		}catch(Exception errorMaquinaCafe){
			System.out.println("Se ha producido una excepcion:"+ errorMaquinaCafe.getMessage());
			
		}
		
		
		
		
		
		
		
	}
	
	
	


}
