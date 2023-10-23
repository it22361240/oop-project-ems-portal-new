<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MCQ <%= 1 %></title>
</head>
<body>
	<h1>View MCQ Questions</h1>
	<c:forEach items="${mcqList}" var="mcq">
		<div>
			<p>Question: ${mcq.question}</p>
			<p>Answers:</p>
			<ul>
				<c:forEach items="${mcq.answers}" var="answer">
					<li>${answer}</li>
				</c:forEach>
			</ul>
			<p>Correct Answer: ${mcq.correctAnswer}</p>
			<p>Marks: ${mcq.marks}</p>
		</div>
	</c:forEach>

</body>
</html>