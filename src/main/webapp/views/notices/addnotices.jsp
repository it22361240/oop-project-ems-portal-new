<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Notice</title>
</head>
<body>
    <h1>Add Notice</h1>
    <form action="../../AddNoticeServlet" method="post">
        Title: <input type="text" name="title"><br>
        Content: <textarea name="content"></textarea><br>
        <input type="submit" value="Add Notice">
    </form>
</body>
</html>
