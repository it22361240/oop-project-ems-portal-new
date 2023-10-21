<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User Profile</title>
    <style>
    /* Form container styling */
    .form-container {
        width: 400px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        background: #f9f9f9;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }
    /* Label styling */
    .form-container label {
        font-weight: bold;
    }
    /* Input field styling */
    .form-container input[type="text"],
    .form-container input[type="password"] {
        width: 100%;
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
    /* Success alert styling */
    .success-alert {
        background-color: #28A745;
        color: white;
        padding: 10px;
        border-radius: 5px;
        text-align: center;
        display: none; /* Hidden by default */
    }
</style>

</head>
<body>
    <div class="form-container">
    <form action="../../UpdateUserServlet" method="post">
        <input type="hidden" name="userId" value="${param.id}">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${param.name}" required><br><br>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${param.email}" required><br><br>

        <label for "phone">Phone:</label>
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