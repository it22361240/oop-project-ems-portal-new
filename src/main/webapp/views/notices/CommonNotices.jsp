<!-- Student Show The Notices Page -->


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notices</title>
</head>
<body>
    <h1>Faculty notices for the students notices</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Content</th>
            <th>Created At</th>
        </tr>
        
        <%@ page import="com.ems.db.DatabaseConnection" %>
        <%@ page import="java.sql.Connection" %>
		<%@ page import="java.sql.Statement" %>
		<%@ page import="java.sql.ResultSet" %>
        <%
            // Code to fetch and display notices from the database
            try {
                Connection conn = DatabaseConnection.getConnection();

                String selectQuery = "SELECT * FROM notices";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    String createdAt = resultSet.getString("created_at");
        %>
        <tr>
            <td><%= id %></td>
            <td><%= title %></td>
            <td><%= content %></td>
            <td><%= createdAt %></td>
        </tr>
        <%
                }
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
    <br>
</body>
</html>
