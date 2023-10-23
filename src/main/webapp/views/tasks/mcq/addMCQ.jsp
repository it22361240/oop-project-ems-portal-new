<!DOCTYPE html>
<html>
<head>
    <title>Add New Task</title>
</head>
<body>
    <h2>MCQ Paper</h2>
    <form action="../../../AddTaskServlet" method="post">
        <label for="taskName">Task Name:</label>
        <input type="text" name="taskName" required><br><br>
        <label for="subjectName">Subject Name :</label><br>
        
        <%
        // Loop question
        int question = 1;
        for(int i = 0; i < question; i++) {
        %>
	        <!-- Question 01 -->
	        <input type="hidden" name="qCount" value="<%= question %>">
	        <label for="question<%= i + 1 %>">Question <%= i + 1 %>:</label>
	        <input type="text" name = "question<%= i + 1 %>" required><br>
        
	        <!-- Answer List -->
	        <%
	        for(int j = 0; j < 4; j++) {
	        %>
		        <label for="ans<%= j + 1 %>">Answer <%= j + 1 %>: </label>
		        <input type="text" name="ans<%= j + 1 %>" required><br>
		    <%
		    }
		    %>
        
        <!-- Correct Answer -->
        <label for="cAns<%= i + 1 %>">Correct Answer for Question <%= i + 1 %>: </label>
        <input type="number" name="cAnswer<%= i + 1 %>" required><br>
        
        <!-- Assigned Marks For the Question -->
        <label for="mark<%= i + 1 %>">Marks for the question <%= i + 1 %>:</label>
        <input type="number" name="mark<%= i + 1 %>" required><br><br><br>
        <%
        }
        %>
        <!-- Submit Form -->
        <input type="submit" value="Submit">
    </form>
</body>
</html>
