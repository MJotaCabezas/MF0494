/**
 * 
 */
package uf2181;

/**
 * @author MJotaCabezas
 *
 */
public class FuncionesDGT {

	
	/**
	 * Función que introduces una lista de números y te devuelve un decimal de la media de todos.
	 * @param puntos en forma de entero. La lista en forma de vector para introducir los números.
	 * @return devuelve la media de esa lista, en forma decimal. 
	 */
	public static double mediaPuntos(int puntos[]) {
		double suma = 0;
		
		for (int i = 0; i < puntos.length; i++) {
			suma = suma +puntos[i];
		}
		if (puntos.length==0) throw new ArrayIndexOutOfBoundsException();
		return suma/puntos.length;
	}
	
	
	/**
	 * Función que sirve para calcular qué tasa de aire tiene permitida según el tipo de conductor. Lo devuelve en forma de verdadero o falso.
	 * @param tipoConductor String según general o profesionales y noveles.
	 * @param aire como boolean, es decir, verdadero o falso.
	 * @return double de la tasa según el tipo de conductor
	 */
	public static double maximaTasaPermitida(String tipoConductor, boolean aire) {
		double tasa=0.25;
		if (tipoConductor.equalsIgnoreCase("General")) {
			if (aire) {
				tasa=0.25;
			} else {
				tasa=0.5;
			}
		} else {
			// profesionales y noveles
			if (aire) {
				tasa=0.15;
			} else {
				tasa=0.3;
			}
		}
		return tasa;
	}

	
}
