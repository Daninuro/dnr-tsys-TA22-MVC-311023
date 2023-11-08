package Act1.Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Act1.Controllers.ControllerClients;

public class VistaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public VistaCliente() {
		
		//CREAR PANEL
		setTitle("Actividad 1");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//BOTON INSERTAR CLIENTES
		JButton btnInsertarClientes = new JButton("Inserta Clientes");
		btnInsertarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.insertarCliente();
			}
		});
		btnInsertarClientes.setEnabled(false);
		btnInsertarClientes.setBounds(55, 126, 144, 25);
		contentPane.add(btnInsertarClientes);
		
		//BOTON BORRAR CLIENTES
		JButton btnBorrarClientes = new JButton("Borrar Clientes");
		btnBorrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.borrarCliente();
			}
		});
		btnBorrarClientes.setEnabled(false);
		btnBorrarClientes.setBounds(55, 186, 144, 25);
		contentPane.add(btnBorrarClientes);
		
		
		
		//BOTON LISTAR CLIENTES
		JButton btnListarClientes = new JButton("Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.listarCliente();
			}
		});
		btnListarClientes.setEnabled(false);
		btnListarClientes.setBounds(242, 126, 153, 25);
		contentPane.add(btnListarClientes);
		
		
		//BOTON MODIFICAR CLIENTES
		JButton btnModificarClientes = new JButton("Modificar Clientes");
		btnModificarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerClients.modificarCliente();
			}
		});
		btnModificarClientes.setEnabled(false);
		btnModificarClientes.setBounds(242, 186, 153, 25);
		contentPane.add(btnModificarClientes);
		
		
		//BOTON CONECTAR BASE DE DATOS
		JButton btnConectarBD = new JButton("Conectar a la Base de Datos");
		btnConectarBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ControllerClients.hacerConexion())
				{
					btnConectarBD.setEnabled(false);
					btnModificarClientes.setEnabled(true);
					btnListarClientes.setEnabled(true);
					btnBorrarClientes.setEnabled(true);
					btnInsertarClientes.setEnabled(true);
				}
			}
		});
		btnConectarBD.setBounds(100, 45, 250, 41);
		contentPane.add(btnConectarBD);
		
	}
}
