package Act3.Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Act1.Controllers.ControllerClients;
import Act2.Controllers.ControllerVideos;
import Act3.Controllers.ControllerCientificos;
import Act3.Controllers.ControllerProyecto;
import Act3.Models.DBConnection;

public class VistaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public VistaMain() {
		
		//CREAR PANEL
		setTitle("Actividad 3");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 376);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//BOTON INSERTAR CIENTIFICOS
		JButton btnInsertarCientificos = new JButton("Insertar Cientificos");
		btnInsertarCientificos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCientificos.insertarCientifico();
			}
		});
		btnInsertarCientificos.setEnabled(false);
		btnInsertarCientificos.setBounds(55, 150, 153, 25);
		contentPane.add(btnInsertarCientificos);
		
		//BOTON BORRAR CIENTIFICOS
		JButton btnBorrarCientificos = new JButton("Borrar Cientificos");
		btnBorrarCientificos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCientificos.borrarCientifico();
			}
		});
		btnBorrarCientificos.setEnabled(false);
		btnBorrarCientificos.setBounds(55, 186, 153, 25);
		contentPane.add(btnBorrarCientificos);
		
		
		
		//BOTON LISTAR CIENTIFICOS
		JButton btnMostrarCientificos = new JButton("Mostrar Cientificos");
		btnMostrarCientificos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCientificos.listarCientifico();
			}
		});
		btnMostrarCientificos.setEnabled(false);
		btnMostrarCientificos.setBounds(55, 114, 153, 25);
		contentPane.add(btnMostrarCientificos);
		
		
		//BOTON MODIFICAR CIENTIFICOS
		JButton btnModificarCientificos = new JButton("Modificar Cientificos");
		btnModificarCientificos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCientificos.modificarCientifico();
			}
		});
		btnModificarCientificos.setEnabled(false);
		btnModificarCientificos.setBounds(55, 225, 153, 25);
		contentPane.add(btnModificarCientificos);
		
		
		//BOTON MOSTRAR PROYECTOS
		JButton btnMostrarProyectos = new JButton("Mostrar Proyectos");
		btnMostrarProyectos.setEnabled(false);
		btnMostrarProyectos.setBounds(281, 115, 153, 25);
		contentPane.add(btnMostrarProyectos);
		
		
		//BOTON INSERTAR PROYECTOS
		JButton btnInsertarProyectos = new JButton("Insertar Proyectos");
		btnInsertarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerProyecto.insertarProyecto();
			}
		});
		btnInsertarProyectos.setEnabled(false);
		btnInsertarProyectos.setBounds(281, 151, 153, 25);
		contentPane.add(btnInsertarProyectos);
		
		
		//BOTON BORRAR PROYECTOS
		JButton btnBorrarProyectos = new JButton("Borrar Proyectos");
		btnBorrarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerProyecto.borrarProyecto();
			}
		});
		btnBorrarProyectos.setEnabled(false);
		btnBorrarProyectos.setBounds(281, 187, 153, 25);
		contentPane.add(btnBorrarProyectos);
		
		
		//BOTON MODIFICAR PROYECTOS
		JButton btnModificarProyectos = new JButton("Modificar Proyectos");
		btnModificarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerProyecto.modificarProyecto();;
			}
		});
		btnModificarProyectos.setEnabled(false);
		btnModificarProyectos.setBounds(281, 226, 153, 25);
		contentPane.add(btnModificarProyectos);
		
		
		
		// BOTON DESCONECTAR BASE DE DATOS
		JButton btnSalirBD = new JButton("Salir de la Base de Datos");
		btnSalirBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCientificos.cerrarConexion();
				dispose(); // Cierra la ventana
			    System.exit(0); // Finaliza la aplicación Java
			}
		});
		btnSalirBD.setEnabled(false);
		btnSalirBD.setBounds(125, 273, 250, 41);
		contentPane.add(btnSalirBD);
		
	
		//BOTON CONECTAR BASE DE DATOS
		JButton btnConectarBD = new JButton("Conectar a la Base de Datos");
		btnConectarBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ControllerClients.hacerConexion())
				{
					//CONECTAR
					btnConectarBD.setEnabled(false);
					//CIENTIFICOS
					btnModificarCientificos.setEnabled(true);
					btnMostrarCientificos.setEnabled(true);
					btnBorrarCientificos.setEnabled(true);
					btnInsertarCientificos.setEnabled(true);
					//PROYECTOS
					btnModificarProyectos.setEnabled(true);
					btnMostrarProyectos.setEnabled(true);
					btnBorrarProyectos.setEnabled(true);
					btnInsertarProyectos.setEnabled(true);
					//SALIR
					btnSalirBD.setEnabled(true);
				}
			}
		});
		btnConectarBD.setBounds(125, 39, 250, 41);
		contentPane.add(btnConectarBD);
	}
}