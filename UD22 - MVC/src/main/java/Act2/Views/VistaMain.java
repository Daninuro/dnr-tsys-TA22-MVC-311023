package Act2.Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Act1.Controllers.ControllerClients;
import Act2.Controllers.ControllerVideos;

public class VistaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public VistaMain() {
		
		//CREAR PANEL
		setTitle("Actividad 2");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 376);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//BOTON INSERTAR CLIENTES
		JButton btnInsertarClientes = new JButton("Insertar Clientes");
		btnInsertarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.insertarCliente();
			}
		});
		btnInsertarClientes.setEnabled(false);
		btnInsertarClientes.setBounds(55, 150, 153, 25);
		contentPane.add(btnInsertarClientes);
		
		//BOTON BORRAR CLIENTES
		JButton btnBorrarClientes = new JButton("Borrar Clientes");
		btnBorrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.borrarCliente();
			}
		});
		btnBorrarClientes.setEnabled(false);
		btnBorrarClientes.setBounds(55, 186, 153, 25);
		contentPane.add(btnBorrarClientes);
		
		
		
		//BOTON LISTAR CLIENTES
		JButton btnMostrarClientes = new JButton("Mostrar Clientes");
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.listarCliente();
			}
		});
		btnMostrarClientes.setEnabled(false);
		btnMostrarClientes.setBounds(55, 114, 153, 25);
		contentPane.add(btnMostrarClientes);
		
		
		//BOTON MODIFICAR CLIENTES
		JButton btnModificarClientes = new JButton("Modificar Clientes");
		btnModificarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.modificarCliente();
			}
		});
		btnModificarClientes.setEnabled(false);
		btnModificarClientes.setBounds(55, 225, 153, 25);
		contentPane.add(btnModificarClientes);
		
		
		//BOTON MOSTRAR CLIENTES
		JButton btnMostrarVideos = new JButton("Mostrar Videos");
		btnMostrarVideos.setEnabled(false);
		btnMostrarVideos.setBounds(281, 115, 153, 25);
		contentPane.add(btnMostrarVideos);
		
		
		//BOTON INSERTAR CLIENTES
		JButton btnInsertarVideos = new JButton("Insertar Videos");
		btnInsertarVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerVideos.insertarVideos();
			}
		});
		btnInsertarVideos.setEnabled(false);
		btnInsertarVideos.setBounds(281, 151, 153, 25);
		contentPane.add(btnInsertarVideos);
		
		
		//BOTON BORRAR CLIENTES
		JButton btnBorrarVideos = new JButton("Borrar Videos");
		btnBorrarVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerVideos.borrarVideos();
			}
		});
		btnBorrarVideos.setEnabled(false);
		btnBorrarVideos.setBounds(281, 187, 153, 25);
		contentPane.add(btnBorrarVideos);
		
		
		//BOTON MODIFICAR CLIENTES
		JButton btnModificarVideos = new JButton("Modificar Videos");
		btnModificarVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerVideos.modificarVideos();;
			}
		});
		btnModificarVideos.setEnabled(false);
		btnModificarVideos.setBounds(281, 226, 153, 25);
		contentPane.add(btnModificarVideos);
		
		
		
		// BOTON DESCONECTAR BASE DE DATOS
		JButton btnSalirBD = new JButton("Salir de la Base de Datos");
		btnSalirBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.cerrarConexion();
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
					//CLIENTES
					btnModificarClientes.setEnabled(true);
					btnMostrarClientes.setEnabled(true);
					btnBorrarClientes.setEnabled(true);
					btnInsertarClientes.setEnabled(true);
					//VIDEOS
					btnModificarVideos.setEnabled(true);
					btnMostrarVideos.setEnabled(true);
					btnBorrarVideos.setEnabled(true);
					btnInsertarVideos.setEnabled(true);
					//SALIR
					btnSalirBD.setEnabled(true);
				}
			}
		});
		btnConectarBD.setBounds(125, 39, 250, 41);
		contentPane.add(btnConectarBD);
	}
}