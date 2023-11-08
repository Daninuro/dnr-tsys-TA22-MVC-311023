package Act2.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnection {

	static Connection conect;
	
	//ABRIR CONEXION CON DATOS INTRODUCIDOS POR PANTALLA
	public static Connection connect(Connection conexionbd) {
		
		String ip = JOptionPane.showInputDialog(null, "Introduce los datos de la conexión sql\nIp:");
		String user = JOptionPane.showInputDialog(null, "Usuario: ");
		String pass = JOptionPane.showInputDialog(null, "Contraseña: ");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexionbd = DriverManager.getConnection("jdbc:mysql://" + ip + ":33060?useTimezone=true&serverTimezone=UTC",
					user, pass);
			JOptionPane.showMessageDialog(null, "Conectado al Sevidor");
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
		return conexionbd;
	}
	
	
	//CREAR DB
		public static void createDB(String name) {
		  
		  try { String Query = "DROP DATABASE IF EXISTS "+name+ " CREATE DATABASE"+name; 
		  Statement st = conect.createStatement(); st.executeUpdate(Query);
		  JOptionPane.showMessageDialog(null,"Se ha creado la base de datos "+name+" de forma exitosa"); 
		  }catch (SQLException ex) 
		  {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		  } 
		}
	
		
	// USAR DB
		public static void useDB(Connection conexionbd, String db) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexionbd.createStatement();
				stdb.executeUpdate(Querydb);

				System.out.println("Usando la " + db + " base de datos");
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}

		}

}