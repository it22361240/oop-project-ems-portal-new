package com.ems.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC driver using Class.forName
        	//DatabaseConfiguration config = new DatabaseConfiguration();
            Class.forName("com.mysql.cj.jdbc.Driver");
            
//            String jdbcUrl = config.getDatabaseURL();
//            String username = config.getDatabaseUsername();
//            String password = config.getDatabasePassword();

            String jdbcUrl = "jdbc:mysql://aws.connect.psdb.cloud/ems?sslMode=VERIFY_IDENTITY";
            String username = "0fgifd8g0kl0me2ns1i0";
            String password = "pscale_pw_EDsdjJX8xYdMKGbX0n8FULAmEgg6sCnAtIig3WKrs0P";

            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database!");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle class not found exception
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
        }
        return null;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle close exception
            }
        }
    }
}
