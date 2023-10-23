<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/views/css/Users_css/studentInsert.css">

</head>

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