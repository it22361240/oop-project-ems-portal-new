<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Image</title>
</head>
<body>
<h1 >ADD IMAGE</h1>

<div align="center">

<form action="../../AddImageServlet" method="post" enctype="multipart/form-data">
   Select Image :
   <input type="file" name="image">
   <input type="submit" value="Add Image">
</form>

</div>

</body>
</html>
