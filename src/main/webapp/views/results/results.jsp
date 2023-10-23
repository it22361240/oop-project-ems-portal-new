<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Results</title>
</head>
<body>
    <h1>Results</h1>
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
    

    <h1>Add Result</h1>
    <form action="../../AddResultServlet" method="post">
        Student ID: <input type="text" name="studentID"><br>
        Student Name: <input type="text" name="studentName"><br>
        Subject: <input type="text" name="subject"><br>
        Marks: <input type="text" name="marks"><br>
        <input type="submit" value="Add Result">
    </form>
        
    <h1>Update Result</h1>
    <form action="../../UpdateResultServlet" method="post">
        Student ID: <input type="text" name="studentID"><br>
        New Marks: <input type="number" name="newMarks"><br>
        <input type="submit" value="Update Result">
    </form>
    
    <h1>Delete Result</h1>
    <form action="../../DeleteResultServlet" method="post">
   		Student ID: <input type="text" name="studentID"><br>
    <input type="submit" value="Delete Result">
	</form>

    <br>
    <a href="./views/results/results.jsp">Add Result</a>
    <a href="./teacherRecorrection.jsp">Re corrections</a>
</body>
</html>
