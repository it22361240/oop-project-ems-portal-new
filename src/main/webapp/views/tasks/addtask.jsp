<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Task</title>
</head>
<body>
    <h2>Add New Task</h2>
    <form action="../../AddTaskServlet" method="post">
        <label for="taskName">Task Name:</label>
        <input type="text" name="taskName" required><br>
        
        <label for="question1">Question 1:</label>
        <input type="text" name="question1" required>
        <label for="marks1">Marks:</label>
        <input type="number" name="marks1" required><br>

        <label for="question2">Question 2:</label>
        <input type="text" name="question2" required>
        <label for="marks2">Marks:</label>
        <input type="number" name="marks2" required><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
