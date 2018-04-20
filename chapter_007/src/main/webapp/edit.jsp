<%@ page import="ru.job4j.servletpool.model.User" %>
<%@ page import="ru.job4j.servletpool.db.UserStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>User list</title>
</head>
<body>
Edit current user: <br/>
<c:forEach items="${users}" var="currentUser">
<form action="${pageContext.servletContext.contextPath}/edit" method="get">
    <input type = "text" name = "id" value = "<c:out value="${currentUser.login}"></c:out> "> <br/>
    <input type = "text" name = "name" value = "<c:out value="${currentUser.name}"></c:out>"> <br/>
    <input type = "text" name = "email" value = "<c:out value="${currentUser.email}"></c:out>"> <br/>
    <input type = "submit" value = "Save">
    </form>
</c:forEach>
<form action= "${pageContext.servletContext.contextPath}/" method="get">
    <input type = "submit" value = "back">
    </form>
</body>
</html>
