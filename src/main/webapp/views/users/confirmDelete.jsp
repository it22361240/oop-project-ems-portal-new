<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Account Confirmation</title>
</head>
<body>
    <form action="../../DeleteUserServlet" method="delete">
        <input type="hidden" name="userId" value="${param.id}">

        <label for="name">Name:</label>
        <input type="text" class="custom-input"id="name" name="name" value="${param.name}" required disabled><br><br>

        <label for="email">Email:</label>
        <input type="text" class="custom-input" id="email" name="email" value="${param.email}" required disabled><br><br>

        <label for="phone">Phone:</label>
        <input type="text" class="custom-input" id="phone" name="phone" value="${param.phone}" required disabled><br><br>

        <label for="username">Username:</label>
        <input type="text" class="custom-input" id="username" name="username" value="${param.username}" required disabled><br><br>

        <label for="password">Password:</label>
        <input type="password" class="custom-input" id="password" name="password" value="${param.password}" required disabled><br><br>

        <input type="submit"  value="Delete Account" onclick="showSuccessAlert()">
    </form>
</body>
</html>