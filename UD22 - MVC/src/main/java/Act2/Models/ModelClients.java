package Act2.Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ModelClients {

	//INSERT INTO CLIENTES
	public static void insertarCliente(Connection databaseConnection, String nombre, String apellidos,
			String direccion, String dni, String fecha) {

		
		try {
			
			String sqlQuery ="INSERT INTO clientes(nombre,apellidos,direccion,dni,fecha) VALUES ('" + nombre + "', '" + apellidos + "', '" + direccion + "', '"+ dni + "', '" + fecha + "');";
						
			Statement sqlStatement = databaseConnection.createStatement();
			
			sqlStatement.executeUpdate(sqlQuery);

			System.out.println("El cliente se ha guardado correctamente en la base de datos!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	//SELECT * FROM CLIENTES
	public static String listarCliente(Connection databaseConnection) {
		StringBuilder clientsList = new StringBuilder();
		
		
		try {
			
			String sqlQuery = "SELECT * FROM clientes;";
			
		
			Statement sqlStatement = databaseConnection.createStatement();
			
			ResultSet sqlQueryResult = sqlStatement.executeQuery(sqlQuery);
			
			ResultSetMetaData resultSetHelper = (ResultSetMetaData) sqlQueryResult.getMetaData();
			
			while (sqlQueryResult.next()) {
			    for (int i = 2; i <= 2; i++) {
			    	clientsList.append(sqlQueryResult.getString(i) + "\n");

			    }
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
		return clientsList.toString();
	}

	//UPDATE CLIENTES
	public static void modificarCliente(Connection databaseConnection, String clienteCambio, String nombre, String apellido,
			String direccion, String dni, String fecha) {
		try {
			
			String sqlQuery = "UPDATE clientes\n" +
							  "SET\n" +
								  "nombre = '" + nombre + "',\n" +
								  "apellido = '" + apellido + "',\n" +
								  "direccion = '" + direccion + "',\n" +
								  "dni = '" + dni + "',\n" +
								  "fecha = '" + fecha + "'\n" +
							  "WHERE\n" +
							  "nombre = '" + clienteCambio + "';";
			
			Statement sqlStatement = databaseConnection.createStatement();
						
			sqlStatement.executeUpdate(sqlQuery);

			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	//DELETE FROM CLIENTES
	public static void borrarCliente(Connection databaseConnection, String nombre) {
		try {
			
			String sqlQuery = "DELETE FROM clientes WHERE nombre = '" + nombre + "';";
			
			Statement sqlStatement = databaseConnection.createStatement();
			
			sqlStatement.executeUpdate(sqlQuery);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}


	public static String buscarCliente(Connection databaseConnection, String nombre) {
		StringBuilder clientData = new StringBuilder();
		
		try {
			
			String sqlQuery = "SELECT * FROM clientes WHERE nombre = '" + nombre + "';";

			Statement sqlStatement = databaseConnection.createStatement();
			
			ResultSet clientToFind = sqlStatement.executeQuery(sqlQuery);
			
			ResultSetMetaData resultSetHelper = (ResultSetMetaData) clientToFind.getMetaData();

			while (clientToFind.next()) {
			    for (int i = 2; i <= resultSetHelper.getColumnCount(); i++) {
			    	
			    	clientData.append(resultSetHelper.getColumnName(i) + ": " + clientToFind.getString(i));
			    	
			        if (i + 1 <= resultSetHelper.getColumnCount())
			        {
			        	clientData.append(", ");
			        }
			    }
			    clientData.append("");
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

		return clientData.toString();
	}
}