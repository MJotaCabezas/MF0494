
package uf2179;

import java.awt.BorderLayout;
import java.awt.EventQueue;import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMultas extends JFrame {
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNombre;
	private JTextField txtApellidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMultas frame = new VentanaMultas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][][][][grow]", "[][][][][][][grow]"));
		JLabel lblNewLabel = new JLabel("DGT - Infracciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel, "cell 0 0 2 1,alignx left");
		JLabel lblNewLabel_1 = new JLabel("Matricula: ");
		contentPane.add(lblNewLabel_1, "flowx,cell 0 1,alignx trailing");
		txtMatricula = new JTextField();
		contentPane.add(txtMatricula, "cell 1 1,growx");
		txtMatricula.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		contentPane.add(lblNewLabel_2, "cell 2 1,alignx trailing");
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 3 1 3 1,growx");
		txtNombre.setColumns(10);
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		contentPane.add(lblNewLabel_3, "cell 0 2,alignx trailing");
		txtApellidos = new JTextField();
		contentPane.add(txtApellidos, "cell 1 2 5 1,growx");
		txtApellidos.setColumns(10);
		JLabel lblNewLabel_4 = new JLabel("Sancion:");
		contentPane.add(lblNewLabel_4, "cell 0 3,alignx trailing");
		JLabel lblImporte = new JLabel("200");
		JComboBox comboSancion = new JComboBox();
		comboSancion.setModel(new DefaultComboBoxModel(new String[] { "No llevar casco", "Conduccion Temeraria" }));
		comboSancion.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				if (comboSancion.getSelectedIndex() == 0) {
					lblImporte.setText("200");
				} else {
					lblImporte.setText("500");
				}
			}
		});
		contentPane.add(comboSancion, "cell 1 3 5 1,growx");
		JLabel lblNewLabel_5 = new JLabel("Importe:");
		contentPane.add(lblNewLabel_5, "cell 0 4,alignx right");
		JLabel lblNewLabel_6 = new JLabel("");
		contentPane.add(lblNewLabel_6, "flowx,cell 1 4");
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 6 6 1,grow");
		JTextArea txtDatos = new JTextArea();
		scrollPane.setViewportView(txtDatos);
		JButton btnAceptar = new JButton("Aceptar");
		contentPane.add(btnAceptar, "cell 1 5,alignx right");
		contentPane.add(lblImporte, "cell 1 4");
		btnAceptar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				int sancion;
				txtDatos.setText(
						txtDatos.getText() + "Conductor: " + txtNombre.getText() + " " + txtApellidos.getText() + "\n");
				txtDatos.setText(txtDatos.getText() + "Infracción: " + comboSancion.getSelectedItem() + "\n");
				
				
				if (comboSancion.getSelectedIndex() == 0) {
					sancion = 200;
				} else {
					sancion = 500;
				}
				txtDatos.setText(txtDatos.getText() + "Importe: " + sancion + "\n");
				txtDatos.setText(txtDatos.getText() + "Pronto pago: " + sancion * 0.5);
			}
		});
	}
}
