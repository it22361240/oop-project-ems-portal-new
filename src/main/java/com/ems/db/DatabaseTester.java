package com.ems.db;

import java.sql.Connection;
//import java.sql.SQLException;

public class DatabaseTester {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Database connection successful.");
            } else {
                System.out.println("Failed to establish a database connection.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while connecting to the database.");
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
}
