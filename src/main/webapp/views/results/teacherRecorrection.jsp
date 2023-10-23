
<!-- Only Teachers can see this page -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Re correction Proposals</h1>
	<table border ="1">
	
	<tr>
		<th>StudentID</th>
		<th>Subject</th>
	</tr>
	
    <%@ page import="java.sql.Connection" %>
	<%@ page import="java.sql.Statement" %>
	<%@ page import="java.sql.ResultSet" %>
	<%@ page import="com.ems.db.DatabaseConnection" %>
	<%
		try {
			// database connection
			Connection conn = DatabaseConnection.getConnection();
			
			// show the recorrection query
			String Query = "Select * from recorrections;";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(Query);
			
			while (resultSet.next()){
				String studentID = resultSet.getString("student_id");
				String subject = resultSet.getString("subject");
		 %>	
				<tr>
		        <td><%= studentID %></td>
		        <td><%= subject %></td>
				</tr>
				
				
		 <%
			}
			conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	%>
	</table>
	<h1>Delete Recorrection</h1>
		<form action="../../DeleteRecorrectionServlet" method="post">
	    Student ID: <input type="text" name="studentID"><br>
	    Subject: <input type="text" name="subject"><br>
	    <input type="submit" value="Delete Recorrection Proposal">
	</form>
	
    <h1>Update Result</h1>
    <form action="../../UpdateResultServlet" method="post">
        Student ID: <input type="text" name="studentID" value="<%= request.getParameter("studentID") %>"><br>
        New Marks: <input type="text" name="newMarks"><br>
        <input type="submit" value="Update Result">
    </form>

	
	
</body>
</html>