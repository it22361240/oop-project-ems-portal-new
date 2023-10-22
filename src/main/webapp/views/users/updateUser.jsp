<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User Profile</title>
    

</head>
<body>
    <div class="form-container">
    <form action="../../UpdateUserServlet" method="post">
        <input type="hidden" name="userId" value="${param.id}">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${param.name}" required><br><br>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${param.email}" required><br><br>

        <label for= "phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${param.phone}" required><br><br>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${param.username}" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${param.password}" required><br><br>

        <input type="submit" value="Update Account" onclick="showSuccessAlert()">
    </form>
    <div class="success-alert" id="success-alert">
        Account updated successfully!
    </div>
</div>

<script>
        function showSuccessAlert() {
            alert("Data has been successfully stored in the database!");
        }
    </script>
</body>
</html>