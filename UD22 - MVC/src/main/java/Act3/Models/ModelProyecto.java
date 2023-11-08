package Act3.Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ModelProyecto {

	//INSERT INTO PROYECTOS
	public static void insertarProyecto(Connection databaseConnection, char id, String nombre, String horas) {

		
		try {
			
			String sqlQuery ="INSERT INTO proyectos(dni,nombre,horas) VALUES ('" + id + "', '" + nombre + "', '" + horas + ");";
						
			Statement sqlStatement = databaseConnection.createStatement();
			
			sqlStatement.executeUpdate(sqlQuery);

			System.out.println("El proyecto se ha guardado correctamente en la base de datos!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	//SELECT * FROM PROYECTOS
	public static String listarProyecto(Connection databaseConnection) {
		StringBuilder videosList = new StringBuilder();
		
		
		try {
			
			String sqlQuery = "SELECT * FROM proyectos;";
			
		
			Statement sqlStatement = databaseConnection.createStatement();
			
			ResultSet sqlQueryResult = sqlStatement.executeQuery(sqlQuery);
			
			ResultSetMetaData resultSetHelper = (ResultSetMetaData) sqlQueryResult.getMetaData();
			
			while (sqlQueryResult.next()) {
			    for (int i = 2; i <= 2; i++) {
			    	videosList.append(sqlQueryResult.getString(i) + "\n");

			    }
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		
		return videosList.toString();
	}

	//UPDATE VIDEOS
	public static void modificarProyecto(Connection databaseConnection, String proyectoCambio, char id, String nombre, String horas) {
		try {
			
			String sqlQuery = "UPDATE proyectos \n" +
							  "SET\n" +
								  "id = '" + id + "',\n" + "nombre = '" + nombre + "',\n" + "horas = '" + horas + "',\n" +
							  "WHERE\n" +
							  "nombre = '" + proyectoCambio + "';";
			
			Statement sqlStatement = databaseConnection.createStatement();
						
			sqlStatement.executeUpdate(sqlQuery);

			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	//DELETE FROM VIDEOS
	public static void borrarVideos(Connection databaseConnection, String nombre) {
		try {
			
			String sqlQuery = "DELETE FROM proyectos WHERE nombre = '" + nombre + "';";
			
			Statement sqlStatement = databaseConnection.createStatement();
			
			sqlStatement.executeUpdate(sqlQuery);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

}