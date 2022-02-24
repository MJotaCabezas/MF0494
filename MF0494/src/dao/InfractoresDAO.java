
/**
*
*/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import conexion.ConexionBD;
import modelo.Infractores;


/**
 * @author MJotaCabezas
 * 
 *  
 *         
 */

public class InfractoresDAO {
	private ConexionBD conexion;

	public InfractoresDAO() {
		this.conexion = new ConexionBD();
	}

	public ArrayList<Infractores> obtenerInfractores() {
		
// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Infractores> lista = new ArrayList<Infractores>();
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from infractores");
			
// Bucle para recorrer todas las filas que devuelve la consulta
			while (resultado.next()) {
				String dni = resultado.getString("dni");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				int antiguedad = resultado.getInt("antiguedad");
				float sancion = resultado.getFloat("sancion");
				int puntos = resultado.getInt("puntos");
				Infractores I = new Infractores(dni, nombre, apellidos,antiguedad,sancion,puntos);
				lista.add(I);
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: " + e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: " + e.getMessage());
			} catch (Exception e) {
			}
		}
		return lista;
	}

	public Infractores obtenerInfractores(String dni) {
		
// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Infractores I = null;
		try {
			consulta = con.prepareStatement("select * from infractores" + "where dni = ?");
			consulta.setString(1, dni);
			consulta.executeQuery();
			
// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				int antiguedad = resultado.getInt("antiguedad");
				float sancion = resultado.getFloat("sancion");
				int puntos = resultado.getInt("puntos");
				
				I = new Infractores(dni, nombre, apellidos, antiguedad, sancion, puntos);
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: " + e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: " + e.getMessage());
			} catch (Exception e) {
			}
		}
		return I;
	}

	public int insertarInfractores(Infractores infractores) {
		
// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado = 0;
		try {
			consulta = con.prepareStatement("INSERT INTO infractores (dni, nombre, apellidos, antiguedad, sancion, puntos)"
		+ " VALUES (?,?,?,?,?,?,?,?) ");
			
			consulta.setString(1, infractores.getDni());
			consulta.setString(2, infractores.getNombre());
			consulta.setString(3, infractores.getApellidos());
			consulta.setInt(4, infractores.getAntiguedad());
			consulta.setFloat(5, infractores.getSancion());
			consulta.setInt(6, infractores.getPuntos());
			resultado = consulta.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: " + e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: " + e.getMessage());
			} catch (Exception e) {
			}
		}
		return resultado;
	}
}