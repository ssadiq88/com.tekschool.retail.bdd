package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opencsv.CSVWriter;

public class DataBaseUtility {
	
	//Java provides JDBC API for connecting to Database
	//JDBC : Java DAta Base Connectivity
	// 1. JDBC provides a class named connection: in order to connect with DB
	//2. JDBC privdes a class maned statment: in order to execute or send a query
	//3. JDBC privdes a class named resultSet: Result Set will store retieved data.
	
	private static Connection  connection;
	private static Statement statement;
	private static ResultSet resultSet;
	
	//JDBC URL and this url will connect framework or java classes to DB
	//Syntax for postgresql: jdbc: postgresql://host:port/databaseName
	private static String url ="jdbc:postgresql:localhost:5432/dvdrental2";
	//username for DB
	private static String userName="postgres";
	//pasword for DB
	private static String password ="snzs";
	
	/**
	 * This method will establish a connection between Java and DB using obj of connection class 
	 * and DriverManager.getConnection method.
	 */
	public static void setupConnection() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet runQuery(String query) {
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
		
	}
	
	public static void returnResult() {
		try {
			while (resultSet.next()){
				CSVWriter csvWriter;
				//provide path for outpiut data file
				
				String output = ".\\output\\book.csv";
				File file = new File(output);
				
				// We need to use File Wirter class to write ResultSet Data from DB to Csvfile
				
				FileWriter fileWriter= new FileWriter(file);
				csvWriter = new CSVWriter(fileWriter);
				csvWriter.writeAll(resultSet, true);
					csvWriter.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close connection to DB 
	 */
	public static void closeDBConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
	}
			
}
