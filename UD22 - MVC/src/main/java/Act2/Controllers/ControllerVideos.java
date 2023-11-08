package Act2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Act2.Models.DBConnection;
import Act2.Models.ModelVideos;
import Act2.Views.VistaMain;

public class ControllerVideos implements ActionListener {
	private ModelVideos video;
	private VistaMain vista;

	static Connection java_connection = null;
	
	public ControllerVideos(ModelVideos video, VistaMain vista) {
		this.setVideos(video);
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
	public static void insertarVideos() {
		JTextField titulo = new JTextField();
		JTextField director = new JTextField();
		JTextField cli_id = new JTextField();

		Object[] message = {
		    "Titulo: ", titulo,
		    "Director: ", director,
		    "Id del Cliente: ", cli_id,
		};

		int result = JOptionPane.showConfirmDialog(null, message, "Inserta un nuevo video", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
		    if (titulo.getText().length() > 0 && director.getText().length() > 0 && cli_id.getText().length() > 0) {
		    	
		    	ModelVideos.insertarVideos(java_connection, titulo.getText().toString(), director.getText().toString(),
		    			Integer.parseInt(cli_id.getText()));
		    	
		    } else {
		        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
		    }
		} else {
			JOptionPane.showMessageDialog(null, "Operacion cancelada");
		}
	}
	
	//BORRAR UN CLIENTE
	public static void borrarVideos() {
		JTextField nombreCliente = new JTextField();

		Object[] mensaje = {
			"Nombre:", nombreCliente
		};
		
		int result = JOptionPane.showConfirmDialog(null, mensaje, "Borrar un cliente", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
			if (nombreCliente.getText().length() > 0)
			{
				ModelVideos.borrarVideos(java_connection, nombreCliente.getText().toString());
				JOptionPane.showMessageDialog(null, "Cliente Eliminado!");
			 } else {
			        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
			    }
			} else {
				JOptionPane.showMessageDialog(null, "Operación cancelada");
			}
	}
	
	//MODIFICA DATOS DE UN CLIENTE
	public static void modificarVideos() {
		JTextField newTitulo = new JTextField();
		JTextField newDirector = new JTextField();
		JTextField newCli_id = new JTextField();
		
		Object[] message = {
		    "New Titulo: ", newTitulo,
		    "New Director:", newDirector,
		    "New Id del Cliente: ", newCli_id,
		};

		String clientToChg = JOptionPane.showInputDialog("Nombre del cliente para modificar");
		
		int result = JOptionPane.showConfirmDialog(null, message, "Actualizar Cliente", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
		    if (newTitulo.getText().length() > 0 && newDirector.getText().length() > 0 && newCli_id.getText().length() > 0) {
		    	ModelVideos.modificarVideos(java_connection, clientToChg, newTitulo.getText().toString(), newDirector.getText().toString(),
		    			Integer.parseInt(newCli_id.getText()));
		    } else {
		        JOptionPane.showMessageDialog(null, "Se tienen que rellenar todos los campos");
		    }
		} else {
			JOptionPane.showMessageDialog(null, "Operación cancelada");
		}
	}
	
	//LISTAR CLIENTES
	public static void listarVideos() {
		JOptionPane.showMessageDialog(null, ModelVideos.listarVideos(java_connection));
	}


	public ModelVideos getVideos() {
		return video;
	}

	public void setVideos(ModelVideos video) {
		this.video = video;
	}

	public VistaMain getVista() {
		return vista;
	}

	public void setVista(VistaMain vista) {
		this.vista = vista;
	}

}
