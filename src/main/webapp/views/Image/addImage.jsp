<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Image Upload</title>
</head>
<body>
    <h2>Upload an Image</h2>
    <form action="../../AddImageServlet" method="post" enctype="multipart/form-data">
        <label for="file">Choose a JPG image:</label>
        <input type="file" name="file" accept=".jpg" required>
        <br><br>
        <input type="submit" value="Upload">
    </form>
</body>
</html>
