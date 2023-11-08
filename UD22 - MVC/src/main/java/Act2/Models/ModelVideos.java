package Act2.Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ModelVideos {

	//INSERT INTO VIDEOS
	public static void insertarVideos(Connection databaseConnection, String titulo, String director, int cli_id) {

		
		try {
			
			String sqlQuery ="INSERT INTO videos(titulo,director,cli_id) VALUES ('" + titulo + "', '" + director + "', '" + cli_id + ");";
						
			Statement sqlStatement = databaseConnection.createStatement();
			
			sqlStatement.executeUpdate(sqlQuery);

			System.out.println("El video se ha guardado correctamente en la base de datos!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	//SELECT * FROM VIDEOS
	public static String listarVideos(Connection databaseConnection) {
		StringBuilder videosList = new StringBuilder();
		
		
		try {
			
			String sqlQuery = "SELECT * FROM videos;";
			
		
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
	public static void modificarVideos(Connection databaseConnection, String videoCambio, String titulo, String director,int cli_id) {
		try {
			
			String sqlQuery = "UPDATE videos \n" +
							  "SET\n" +
								  "titulo = '" + titulo + "',\n" + "director = '" + director + "',\n" + "cli_id = '" + cli_id + "',\n" +
							  "WHERE\n" +
							  "titulo = '" + videoCambio + "';";
			
			Statement sqlStatement = databaseConnection.createStatement();
						
			sqlStatement.executeUpdate(sqlQuery);

			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

	//DELETE FROM VIDEOS
	public static void borrarVideos(Connection databaseConnection, String titulo) {
		try {
			
			String sqlQuery = "DELETE FROM videos WHERE titulo = '" + titulo + "';";
			
			Statement sqlStatement = databaseConnection.createStatement();
			
			sqlStatement.executeUpdate(sqlQuery);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}

}