
<!-- Only student can see this page -->

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
	
	<a href="/project/views/results/CommonResults.jsp">Add the re correction</a>
</body>
</html>