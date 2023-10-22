<!DOCTYPE html>
<html>
<head>
    <title>Add New Task</title>
</head>
<body>
    <h2>MCQ Paper</h2>
    <form action="../../../AddTaskServlet" method="post" onsubmit="openSuccessModal()">
        <label for="taskName">Task Name:</label>
        <input type="text" name="taskName" required><br><br>
        
        <%
        // Loop question
        for(int i = 0; i < 2; i++) {
        %>
	        <!-- Question 01 -->
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
        <input type="number" name="cAns<%= i + 1 %>" required><br>
        
        <!-- Assigned Marks For the Question -->
        <label for="mark<%= i + 1 %>">Marks for the question <%= i + 1 %>:</label>
        <input type="number" name="mark<%= i + 1 %>" required><br><br><br>
        <%
        }
        %>
        <!-- Submit Form -->
        <input type="submit" value="Submit">
    </form>

    <!-- Success modal -->
    <div id="successModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeSuccessModal()">&times;</span>
            <p>Success: Your task was added successfully!</p>
        </div>
    </div>

    <script>
    // Function to open the success modal
    function openSuccessModal() {
        var success = <%= request.getAttribute("success") %>;
        if (success) {
            document.getElementById("successModal").style.display = "block";
        }
    }

    // Function to close the success modal
    function closeSuccessModal() {
        document.getElementById("successModal").style display = "none";
    }
    
    window.onload = openSuccessModal; // Corrected function name
</script>

</body>
</html>
