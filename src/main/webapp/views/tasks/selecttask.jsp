<%@ page import="jakarta.servlet.http.HttpServlet" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Select Task</title>
</head>
<body>
    <h2>Select Task Type</h2>
    	<a href="./mcq/addMCQ.jsp" class="button" id="mcq">MCQ</a>
    	<a href="./addESSAY.jsp" class="button" id="essay">ESSAY</a>
    	
    	<script>
    // JavaScript code to handle the button click event
    document.getElementById("mcq").onclick = function() {
    		var returnedValue = "mcq";
    };
    document.getElementById("essay").onclick = function() {
		var returnedValue = "essay";
	};
  </script>
</body>
</html>
