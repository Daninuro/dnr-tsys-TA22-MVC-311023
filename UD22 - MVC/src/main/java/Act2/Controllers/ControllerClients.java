package Act2.Controllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Act2.Models.DBConnection;
import Act2.Models.ModelClients;
import Act2.Views.VistaMain;

public class ControllerClients implements ActionListener {
	private ModelClients cliente;
	private VistaMain vista;

	static Connection java_connection = null;
	
	public ControllerClients(ModelClients clients, VistaMain vista) {
		this.setCliente(clients);
		this.setVista(vista);
		
		// aqui se van asignando los actions a los elemntos de la vista
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	//HACER CONNECTION
	public static boolean hacerConexion() {
		java_connection = DBConnection.connect(java_connection);
		
		DBConnection.useDB(java_connection, "ud22");
		
		return ((java_connection != null) ? true : false);
	}
	
	//INSERTAR CLIENTE
	public static void insertarCliente() {
		JTextField nombre = new JTextField();
		JTextField apellidos = new JTextField();
		JTextField direccion = new JTextField();
		JTextField dni = new JTextField();
		JTextField fecha = new JTextField();
		Object[] message = {
		    "Nombre: ", nombre,
		    "Apellidos:", apellidos,
		    "Direccion: ", direccion,
		    "Ident. Num.: ", dni,
		    "Fecha: ", fecha
		};

		int result = JOptionPane.showConfirmDialog(null, message, "Inserta un nuevo cliente", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
		    if (nombre.getText().length() > 0 && apellidos.getText().length() > 0 && direccion.getText().length() > 0 &&
		    		dni.getText().length() > 0 && fecha.getText().length() > 0) {
		    	
		    	ModelClients.insertarCliente(java_connection, nombre.getText().toString(), apellidos.getText().toString(),
		    			direccion.getText().toString(), dni.getText().toString(), fecha.getText().toString());
		    	
		    } else {
		        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
		    }
		} else {
			JOptionPane.showMessageDialog(null, "Operacion cancelada");
		}
	}
	
	//BORRAR UN CLIENTE
	public static void borrarCliente() {
		JTextField nombreCliente = new JTextField();

		Object[] mensaje = {
			"Nombre:", nombreCliente
		};
		
		int result = JOptionPane.showConfirmDialog(null, mensaje, "Borrar un cliente", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
			if (nombreCliente.getText().length() > 0)
			{
				ModelClients.borrarCliente(java_connection, nombreCliente.getText().toString());
				JOptionPane.showMessageDialog(null, "Cliente Eliminado!");
			 } else {
			        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
			    }
			} else {
				JOptionPane.showMessageDialog(null, "Operación cancelada");
			}
	}
	
	//MODIFICA DATOS DE UN CLIENTE
	public static void modificarCliente() {
		JTextField newNombre = new JTextField();
		JTextField newApellidos = new JTextField();
		JTextField newDireccion = new JTextField();
		JTextField newDni = new JTextField();
		JTextField newFecha = new JTextField();
		
		Object[] message = {
		    "New Name: ", newNombre,
		    "New Surname:", newApellidos,
		    "New Address: ", newDireccion,
		    "New Ident. Num.: ", newDni,
		    "New Date: ", newFecha
		};

		String clientToChg = JOptionPane.showInputDialog("Nombre del cliente para modificar");
		
		int result = JOptionPane.showConfirmDialog(null, message, "Actualizar Cliente", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
		    if (newNombre.getText().length() > 0 && newApellidos.getText().length() > 0 && newDireccion.getText().length() > 0 &&
		    		newDni.getText().length() > 0 && newFecha.getText().length() > 0) {
		    	ModelClients.modificarCliente(java_connection, clientToChg, newNombre.getText().toString(), newApellidos.getText().toString(),
		    			newDireccion.getText().toString(), newDni.getText().toString(), newFecha.getText().toString());
		    } else {
		        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
		    }
		} else {
			JOptionPane.showMessageDialog(null, "Operación cancelada");
		}
	}
	
	//LISTAR CLIENTES
	public static void listarCliente() {
		JOptionPane.showMessageDialog(null, ModelClients.listarCliente(java_connection));
	}


	public ModelClients getCliente() {
		return cliente;
	}

	public void setCliente(ModelClients cliente) {
		this.cliente = cliente;
	}

	public VistaMain getVista() {
		return vista;
	}

	public void setVista(VistaMain vista) {
		this.vista = vista;
	}

}