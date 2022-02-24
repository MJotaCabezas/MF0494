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
	 * Funci�n que introduces una lista de n�meros y te devuelve un decimal de la media de todos.
	 * @param puntos en forma de entero. La lista en forma de vector para introducir los n�meros.
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
	 * Funci�n que sirve para calcular qu� tasa de aire tiene permitida seg�n el tipo de conductor. Lo devuelve en forma de verdadero o falso.
	 * @param tipoConductor String seg�n general o profesionales y noveles.
	 * @param aire como boolean, es decir, verdadero o falso.
	 * @return double de la tasa seg�n el tipo de conductor
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
