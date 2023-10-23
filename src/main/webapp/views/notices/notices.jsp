<!-- This Is The Main Notice Notice View For Teachers -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notices</title>
</head>
<body>
    <h1>Notices</h1>
    <table border="1">
        <tr>
            <th>Notice Number</th>
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
	
		        <td><a href="/project/DeleteNoticeServlet?id=<%= id %>">Delete</a></td>
		    </tr>

        <%
                }
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
    
    <h1>Update Notice</h1>
    <form action="../../UpdateNoticeServlet" method="post">
        Notice number: <input type="number" name="id" value="<%= request.getParameter("id") %>"><br>
        Title: <input type="text" name="title" value="<%= request.getParameter("title") %>"><br>
        Content: <textarea name="content"><%= request.getParameter("content") %></textarea><br>
        <input type="submit" value="Update Notice">
    </form>
    <br>
    
    <h1>Add Notice</h1>
    <form action="../../AddNoticeServlet" method="post">
        Title: <input type="text" name="title"><br>
        Content: <textarea name="content"></textarea><br>
        <input type="submit" value="Add Notice">
    </form>
</body>
</html>
