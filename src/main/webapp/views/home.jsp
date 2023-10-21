<%@ page import="jakarta.servlet.http.HttpServlet" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bootstrap demo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<style>
 .login-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 50vh;
        }
        .login-form {
            width: 350px;
            padding: 20px;
            border: 1px solid #ccc;
            background: #f9f9f9;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        .login-form label {
            font-weight: bold;
        }
        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .login-form input[type="submit"] {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .login-form input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .register-button {
            margin-top: 10px;
            background-color: #28A745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .register-button:hover {
            background-color: #1d8c3a;
        }
</style>
<body>
<jsp:include page="./components/header.jsp" />

<div class="login-container">
        <div class="login-form">
            <h2>Login Form</h2>
            <form action="../loginServlet" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>
                <input class="btn btn-primary" type="submit" value="Login">
            </form>
            <button class="register-button" id="register-button">Register</button>
        </div>
    </div>
<script>
        document.getElementById("register-button").onclick = function () {
            // Redirect to a new page
            window.location.href = "./users/studentInsert.jsp";
        };
    </script>
<jsp:include page="./components/footer.jsp" />
</body>

</html>