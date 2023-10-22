<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Results</title>
</head>
<body>
    <h1>Results Released</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Subject</th>
            <th>Marks</th>
        </tr>
         	<%@ page import="com.ems.db.DatabaseConnection" %>
	        <%@ page import="java.sql.Connection" %>
			<%@ page import="java.sql.Statement" %>
			<%@ page import="java.sql.ResultSet" %>
        <%
            try {
            	// Establish a database connection
                Connection conn = DatabaseConnection.getConnection();

                String selectQuery = "SELECT * FROM results";
                java.sql.Statement statement = conn.createStatement();
                java.sql.ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    String studentID = resultSet.getString("student_id");
                    String studentName = resultSet.getString("student_name");
                    String subject = resultSet.getString("subject");
                    int marks = resultSet.getInt("marks");
        %>
        <tr>
            <td><%= studentID %></td>
            <td><%= studentName %></td>
            <td><%= subject %></td>
            <td><%= marks %></td>
        </tr>
        
        <%
                }
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
    
    <!--    for the another CRUD operation as fill re correction form by the students
     <h1>Fill the re correction form for students</h1>
    <form action="" method="post">
        Student ID: <input type="text" name="studentID"><br>
        Subject: <input type="text" name="text"><br>
        <input type="submit" value="Update Result">
    </form> -->
    <br>
</body>
</html>