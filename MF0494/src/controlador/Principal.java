package controlador;

public class Principal {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		controlador.inciarPrograma();
	}
	private Controlador controlador;
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;		
	}
}
