/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.ConexionBD;

import dao.InfractoresDAO;
import dao.SancionDAO;
import modelo.Infractores;

import modelo.Sancion;
import vista.DialogoInsertarInfractor;
import vista.VentanaMostrarInfractores;
import vista.VentanaPpal;

/**
 * @author MJotaCabezas
 *
 */
public class Controlador {

	// VEntanas del sistema
	private VentanaPpal ventanaPpal;
	private DialogoInsertarInfractor dialogoInsertarInfractor;
	private VentanaMostrarInfractores ventanaMostrarInfractores;
	
	// Objetos DAO o CRUD de la base de datos
	private SancionDAO sancionDAO;
	private InfractoresDAO infractoresDAO;

	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		dialogoInsertarInfractor = new DialogoInsertarInfractor();
		ventanaMostrarInfractores= new VentanaMostrarInfractores();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoInsertarInfractor.setControlador(this);
		ventanaMostrarInfractores.setControlador(this);
		
		// Creamos los objetos DAO
		sancionDAO = new SancionDAO();
		infractoresDAO= new InfractoresDAO();
	}
	
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}

	public void mostrarInsertarInfractores () {
		ArrayList<Sancion> listaSanciones = new ArrayList<Sancion>();
		listaSanciones = sancionDAO.obtenerSanciones();
		dialogoInsertarInfractor.setListaSanciones(listaSanciones);
		dialogoInsertarInfractor.setVisible(true);
	}
	
	public void mostrarListarInfractores() {
		ArrayList<Infractores> lista = infractoresDAO.obtenerInfractores();
		ventanaMostrarInfractores.setListaInfractores(lista);
		ventanaMostrarInfractores.setVisible(true);
	}
	
	public void VentanamostrarInfractores () {
		
		ArrayList<Infractores> lista = ConexionBD.mostrarInfractores();
		
		ventanaMostrarInfractores.setListaInfractores(lista);
		ventanaMostrarInfractores.setVisible(true);
}
	
	public void insertaInfractor(Infractores infractores) {
		
		int resultado = infractoresDAO.insertarInfractores(infractores);
		if (resultado == 0) {
			JOptionPane.showMessageDialog(dialogoInsertarInfractor, "Error al insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoInsertarInfractor, "Inserción de infractores correcta");
			dialogoInsertarInfractor.setVisible(false);
		}
	}
}
