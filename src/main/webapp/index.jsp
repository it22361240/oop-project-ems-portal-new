<%@ page import="jakarta.servlet.http.HttpServlet" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello this is login page</h1>
<h2>Login Form</h2>
<div>
    <form action="loginServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    <button id="register-button"> Register</button>
</div>
<script>
        document.getElementById("register-button").onclick = function () {
            // Redirect to a new page
            window.location.href = "studentInsert.jsp";
        };
    </script>

</body>
</html>