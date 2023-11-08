package Act3.Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ModelCientificos {

	//INSERT INTO CIENTIFICOS
	public static void insertarCientifico(Connection databaseConnection, String dni, String nom_apell) {

		
		try {
			
			String sqlQuery ="INSERT INTO cientificos(dni,nom_apell) VALUES ('" + dni + "', '" + nom_apell + "');";
						
			Statement sqlStatement = databaseConnection.createStatement();
			
			sqlStatement.executeUpdate(sqlQuery);

			System.out.println("El Cientifico se ha guardado correctamente en la base de datos!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	//SELECT * FROM CIENTIFICOS
	public static String listarCientifico(Connection databaseConnection) {
		StringBuilder cientificoList = new StringBuilder();
		
		
		try {
			
			String sqlQuery = "SELECT * FROM cientificos;";
			
		
			Statement sqlStatement = databaseConnection.createStatement();
			
			ResultSet sqlQueryResult = sqlStatement.executeQuery(sqlQuery);
			
			ResultSetMetaData resultSetHelper = (ResultSetMetaData) sqlQueryResult.getMetaData();
			
			while (sqlQueryResult.next()) {
			    for (int i = 2; i <= 2; i++) {
			    	cientificoList.append(sqlQueryResult.getString(i) + "\n");

			    }
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
		return cientificoList.toString();
	}

	//UPDATE CIENTIFICOS
	public static void modificarCientifico(Connection databaseConnection, String nombreCambio, String dni, String nom_apell) {
		try {
			
			String sqlQuery = "UPDATE cientificos\n" +
							  "SET\n" +
								  "nombre = '" + dni + "',\n" +
								  "apellido = '" + nom_apell + "',\n" +
							  "WHERE\n" +
							  "nombre = '" + nombreCambio + "';";
			
			Statement sqlStatement = databaseConnection.createStatement();
						
			sqlStatement.executeUpdate(sqlQuery);

			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	//DELETE FROM CIENTIFICOS
	public static void borrarCientifico(Connection databaseConnection, String nom_apell) {
		try {
			
			String sqlQuery = "DELETE FROM cientificos WHERE nom_apell = '" + nom_apell + "';";
			
			Statement sqlStatement = databaseConnection.createStatement();
			
			sqlStatement.executeUpdate(sqlQuery);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}


	public static String buscarCientifico(Connection databaseConnection, String nom_apell) {
		StringBuilder cientificData = new StringBuilder();
		
		try {
			
			String sqlQuery = "SELECT * FROM cientificos WHERE nombre = '" + nom_apell + "';";

			Statement sqlStatement = databaseConnection.createStatement();
			
			ResultSet cientifToFind = sqlStatement.executeQuery(sqlQuery);
			
			ResultSetMetaData resultSetHelper = (ResultSetMetaData) cientifToFind.getMetaData();

			while (cientifToFind.next()) {
			    for (int i = 2; i <= resultSetHelper.getColumnCount(); i++) {
			    	
			    	cientificData.append(resultSetHelper.getColumnName(i) + ": " + cientifToFind.getString(i));
			    	
			        if (i + 1 <= resultSetHelper.getColumnCount())
			        {
			        	cientificData.append(", ");
			        }
			    }
			    cientificData.append("");
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}

		return cientificData.toString();
	}
}