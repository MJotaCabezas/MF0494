/**
 * 
 */
package uf2178;

import java.util.Scanner;

/**
 * @author MJotaCabezas
 *
 */
public class Ppal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Escribe aquí las sentencias del apartado 3
		
		//System.out.println("Introduce tasa de alcoholemia");
		Scanner entrada = new Scanner(System.in);
		//Float tasa = entrada.nextFloat();
		//Funciones.calculaSancion(tasa);
	

		int puntos []= new int [6];
		int sanciones []= new int [6];

	System.out.println("Introduce el vector:  ");
	Funciones.pedir_vector(puntos);
	
	System.out.println("Introduce el segundo vector:  ");
	Funciones.pedir_vector(sanciones);
	
	Funciones.mostrar_vector(puntos);
	Funciones.mostrar_vector(sanciones);
	
	
	Funciones.restaPuntos(puntos, sanciones);
	
	Funciones.mostrar_vector(puntos);
	
	}
}

