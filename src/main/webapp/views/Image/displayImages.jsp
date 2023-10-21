<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Display Images</title>
</head>
<body>
    <h1>Display Images</h1>

    <div align="center">
    	<form action="../../DisplayServlet" method="post" enctype="multipart/form-data">
    		Enter form id : <input type = "number" name="imageId">
    		<input type= "submit" value="Display Image">
    	</form>
    </div>
    
    <hr>
    <%
    	String imgFileName = (String)request.getAttribute("img");
    	String imgId = (String)request.getAttribute("id");
    %>
    
    <div align ="center">
    	<table border="5px" style="width:600px;">
    <tr>
    	<td> Image ID </td>
    	<td> Image </td>
    </tr>
    	<%
    		if(imgFileName!= "" && imgId!="" ){
    	%>
    	
    	<tr>
    		<td><%=imgId %></td>
    		<td><img src= "oop-project-ems-portal-new/src/main/webapp/views/Image/UploadedImage/<%=imgFileName %>"></td>
    	</tr>
    	
    	<%
    		}
    	%>
    	</table>
    </div>
</body>
</html>
