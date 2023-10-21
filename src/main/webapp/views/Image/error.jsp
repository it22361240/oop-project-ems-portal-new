<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Error</title>
</head>
<body>
    <h2>Upload Error</h2>
    <p>An error occurred during the image upload. Please try again later.</p>
    <!-- You can provide links or options for the user to navigate back to the upload form or take other actions. -->
    <p><a href="addImage.jsp">Try Again</a></p>
    <!-- Additionally, you can display an error message to provide more information about the error. -->
    <p><%= request.getAttribute("errorMessage") %></p>
</body>
</html>
