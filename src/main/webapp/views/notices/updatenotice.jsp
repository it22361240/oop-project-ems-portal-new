<%-- updatenotice.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Notice</title>
</head>
<body>
    <h1>Update Notice</h1>
    <form action="../../UpdateNoticeServlet" method="post">
        Notice number: <input type="number" name="id" value="<%= request.getParameter("id") %>">
        Title: <input type="text" name="title" value="<%= request.getParameter("title") %>"><br>
        Content: <textarea name="content"><%= request.getParameter("content") %></textarea><br>
        <input type="submit" value="Update Notice">
    </form>
</body>
</html>
