<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Database Connection Status</title>
</head>
<body>
    <h1>Database Connection Status</h1>
    
    <% 
        try {
            // Import your DatabaseConnection class
            com.ems.db.DatabaseConnection dbConnection = new com.ems.db.DatabaseConnection();

            // Get a connection
            java.sql.Connection conn = dbConnection.getConnection();

            // Check if the connection is not null
            if (conn != null) {
                out.println("<p style='color:green;'>Database connection is successful!</p>");
                // You can perform further database operations here
                // ...
            } else {
                out.println("<p style='color:red;'>Failed to connect to the database.</p>");
            }

            // Close the connection
            dbConnection.closeConnection(conn);
        } catch (Exception e) {
            out.println("<p style='color:red;'>An error occurred while connecting to the database.</p>");
            e.printStackTrace();
        }
    %>
</body>
</html>
