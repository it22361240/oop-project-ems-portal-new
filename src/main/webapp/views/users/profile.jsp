<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<h1>Login successfully</h1>
<p> Recieved Id : ${id }</p>
<h1>Login successfully</h1>
   <p>Received username: ${username}</p>
    <p>Received password: ${password}</p>
    <p>Received email: ${email}</p>
    <p>Received name: ${name}</p>
    <p>Received phone: ${phone}</p>
    <c:url value="./views/users/updateUser.jsp" var="update">
    	<c:param name = "id" value = "${username}"/>
    </c:url>
    <%-- <a href="${update}">  		
    <button id="update">update</button>
    </a> --%>
    <button id="update">update</button>
    <button id="delete" class="btn btn-outline-danger">delete</button>
    <script>
    document.getElementById("update").addEventListener("click", function() {
        // Define the values you want to send to the new JSP
        var id = "${id}";
        var username = "${username}";
        var password = "${password}";
        var email = "${email}";
        var name = "${name}";
        var phone = "${phone}";
        // Construct the URL with parameters
        var url = "./views/users/updateUser.jsp?id=" + id + "&password=" + password+ "&email=" + email+ "&name=" + name+ "&phone=" + phone+ "&username=" + username;
        // Redirect to the new JSP
        window.location.href = url;
    });
    
    document.getElementById("delete").addEventListener("click", function() {
        // Define the values you want to send to the new JSP
        var id = "${id}";
        var username = "${username}";
        var password = "${password}";
        var email = "${email}";
        var name = "${name}";
        var phone = "${phone}";
        // Construct the URL with parameters
        var url = "./views/users/confirmDelete.jsp?id=" + id + "&password=" + password+ "&email=" + email+ "&name=" + name+ "&phone=" + phone+ "&username=" + username;
        // Redirect to the new JSP
        window.location.href = url;
    });
        
    </script>
</body>
</html>