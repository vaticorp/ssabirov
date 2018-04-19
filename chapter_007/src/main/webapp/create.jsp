<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>User list</title>
</head>
<body>Create new user: <br/>
<form action="${pageContext.servletContext.contextPath}/create" method="post">
    <p>Login: <input type = "text" name = "login"> <br/></p>
    <p>Name:  <input type = "text" name = "name"> <br/></p>
    <p>E-mail:<input type = "text" name = "email"> <br/></p>
    <input type = "submit" value = "Save">
</form>
<form action="${pageContext.servletContext.contextPath}/" method="get">
    <input type = "submit" value = "Back">
</form>
</body>
</html>
