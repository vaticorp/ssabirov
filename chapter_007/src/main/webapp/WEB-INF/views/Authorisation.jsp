<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p1>Enter the system:</p1> <br/><br/>
<c:if test="${error != ''}">
    <div style="background-color: blue">
       <c:out value="${error}"></c:out>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/signin" method="post">
    <p2>Login: <input type = "text" name = "login"> <br/><br/></p2>
    <p2>Password:  <input type = "password" name = "password"> <br/></p2>
    <input type = "submit" value = "log-on">
</form>
</body>
</html>
