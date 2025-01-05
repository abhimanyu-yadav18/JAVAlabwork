package servletfolder;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataconn {

	public dataconn() {
		// TODO Auto-generated constructor stub
	}

	 // Database URL, Username, and Password
    private static final String URL = "jdbc:mysql://localhost:3306/christattendence"; // Replace with your database name
    private static final String USERNAME = "root"; // Default username for XAMPP
    private static final String PASSWORD = "";     // Default password for XAMPP

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found. Ensure the .jar file is added to the lib folder.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database. Check your URL, username, or password.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Test the connection
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connection test successful!");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}







