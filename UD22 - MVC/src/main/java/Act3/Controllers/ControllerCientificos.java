package Act3.Controllers;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Act2.Models.DBConnection;
import Act2.Views.VistaMain;
import Act3.Models.ModelCientificos;

public class ControllerCientificos implements ActionListener {
	private ModelCientificos cientifico;
	private VistaMain vista;

	static Connection java_connection = null;
	
	public ControllerCientificos(ModelCientificos cientifico, VistaMain vista) {
		this.setCientifico(cientifico);
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
		
		DBConnection.useDB(java_connection, "ud22_03");
		
		return ((java_connection != null) ? true : false);
	}
	
	//CERRAR CONEXIÓN
		public static boolean cerrarConexion() {
		    if (java_connection != null) {
		        try {
		            java_connection.close();
		            JOptionPane.showMessageDialog(null, "Conexión cerrada con éxito");
		            System.out.println("Conexión cerrada con éxito.");
		            return true;
		        } catch (SQLException e) {
		            System.out.println("Error al cerrar la conexión: " + e.getMessage());
		            return false;
		        }
		    }
		    return false;
		}	
		
	//INSERTAR CLIENTE
	public static void insertarCientifico() {
		JTextField dni = new JTextField();
		JTextField nom_apell = new JTextField();

		Object[] message = {
		    "DNI: ", dni,
		    "Nombre y Apellido:", nom_apell
		};

		int result = JOptionPane.showConfirmDialog(null, message, "Inserta un nuevo cliente", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
		    if (dni.getText().length() > 0 && nom_apell.getText().length() > 0) {
		    	
		    	ModelCientificos.insertarCientifico(java_connection, dni.getText().toString(), nom_apell.getText().toString());
		    	
		    } else {
		        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
		    }
		} else {
			JOptionPane.showMessageDialog(null, "Operacion cancelada");
		}
	}
	
	//BORRAR UN CLIENTE
	public static void borrarCientifico() {
		JTextField nombreCientifico = new JTextField();

		Object[] mensaje = {
			"Nombre:", nombreCientifico
		};
		
		int result = JOptionPane.showConfirmDialog(null, mensaje, "Borrar un cientifico", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
			if (nombreCientifico.getText().length() > 0)
			{
				ModelCientificos.borrarCientifico(java_connection, nombreCientifico.getText().toString());
				JOptionPane.showMessageDialog(null, "Cientifico Eliminado!");
			 } else {
			        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
			    }
			} else {
				JOptionPane.showMessageDialog(null, "Operación cancelada");
			}
	}
	
	//MODIFICA DATOS DE UN CLIENTE
	public static void modificarCientifico() {
		JTextField newDNI = new JTextField();
		JTextField newnom_apell = new JTextField();

		
		Object[] message = {
		    "New Name: ", newDNI,
		    "New Surname:", newnom_apell
		};

		String cientifToChg = JOptionPane.showInputDialog("Nombre del cientifico para modificar");
		
		int result = JOptionPane.showConfirmDialog(null, message, "Actualizar Cientifico", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
		    if (newDNI.getText().length() > 0 && newnom_apell.getText().length() > 0) {
		    	ModelCientificos.modificarCientifico(java_connection, cientifToChg, newDNI.getText().toString(), newnom_apell.getText().toString());
		    } else {
		        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
		    }
		} else {
			JOptionPane.showMessageDialog(null, "Operación cancelada");
		}
	}
	
	//LISTAR CLIENTES
	public static void listarCientifico() {
		JOptionPane.showMessageDialog(null, ModelCientificos.listarCientifico(java_connection));
	}


	public ModelCientificos getCientifico() {
		return cientifico;
	}

	public void setCientifico(ModelCientificos cientifico) {
		this.cientifico = cientifico;
	}

	public VistaMain getVista() {
		return vista;
	}

	public void setVista(VistaMain vista) {
		this.vista = vista;
	}

}