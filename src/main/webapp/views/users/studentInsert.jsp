<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    /* Form container styling */
    .form-container {
        width: 300px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        background: #f9f9f9;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }
    /* Input field styling */
    .form-container input[type="text"],
    .form-container input[type="password"] {
        width: 90%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
    /* Submit button styling */
    .form-container input[type="submit"] {
        background-color: #007BFF;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }
    /* Submit button hover effect */
    .form-container input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
<body>


<form action="insert" method="post">


</form>
<div class="form-container">
    <form action="../../SignUpServlet" method="post">
        Name <input type="text" name="name"><br>
        Email <input type="text" name="email"><br>
        Phone Number <input type="text" name="phone"><br>
        User Name <input type="text" name="uid"><br>
        Password <input type="password" name="psw"><br>
        <input type="submit" name="submit" value="Create Student">
    </form>
</div>
</body>
</html>