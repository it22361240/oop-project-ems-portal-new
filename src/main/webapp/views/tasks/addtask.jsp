<!DOCTYPE html>
<html>
<head>
    <title>Add New Task</title>
    <style>
        /* Style for the modal */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #f4f4f4;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
            text-align: center;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h2>Add New Task</h2>
    <form action="../../AddTaskServlet" method="post" onsubmit="openSuccessModal()">
        <label for="taskName">Task Name:</label>
        <input type="text" name="taskName" required><br>
        
        <label for="question1">Question 1:</label>
        <input type="text" name = "question1" required>
        <label for="marks1">Marks:</label>
        <input type="number" name="marks1" required><br>

        <label for="question2">Question 2:</label>
        <input type="text" name="question2" required>
        <label for="marks2">Marks:</label>
        <input type="number" name="marks2" required><br>
        
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
            document.getElementById("successModal").style.display = "block";
        }

        // Function to close the success modal
        function closeSuccessModal() {
            document.getElementById("successModal").style.display = "none";
        }
    </script>
</body>
</html>
