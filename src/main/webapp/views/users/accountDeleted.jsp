<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Deleted</title>
</head>
<body>
    <h1>Account Deleted</h1>
    <p>Your user account has been "${param.status}".</p>
    <button class="btn btn-outline-warning" onclick="navigateToAnotherPage()"> OK GO</button>
    <script>
        function navigateToAnotherPage() {
            
            window.location.href = "../home.jsp"; 
        }
    </script>
</body>
</html>