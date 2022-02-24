/**
 * 
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Infractores;

/**
 * @author David
 *
 */
public class ConexionBD {

	private static final String database = "dgt";
	private static final String usuario = "root";
	private static final String contrase�a = "1401";
	private static final String url="jdbc:mysql://localhost/"+database;
	
	private Connection conexion=null;
	
	
	public Connection getConexion() {
		if (conexion!=null) {
			return conexion;
		}
		
		// REgistra el driver de MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection(url, usuario, contrase�a);
			System.out.println("Conexion a dgt correcta");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no registrado");
		} catch (SQLException e) {
			System.out.println("Error SQLException: "+e.getMessage());
		}
		return conexion;
	}
	
	public void desconectar() {
		try {
			conexion.close();
			conexion=null;
		} catch (SQLException e) {
			System.out.println("Erorr cerrrando la conexion "+ e.getMessage());
		}
	}

	public static ArrayList<Infractores> mostrarInfractores() {
		// TODO Esbozo de m�todo generado autom�ticamente
		return null;
	}

}
