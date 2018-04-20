<%@ page import="ru.job4j.servletpool.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.job4j.servletpool.db.UserStore" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<table border = '2' bgcolor = '#efefef'>
    <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.login}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td>
            <form action="${pageContext.servletContext.contextPath}/edit?id=<c:out value="${user.login}"></c:out>" method="post">
                <input type = "submit" name = "<c:out value="${user.login}"></c:out>" value = "Edit"></form>
        </td>
        <td>
            <form action="${pageContext.servletContext.contextPath}/list" method="post">
                <input type = "submit" name = "<c:out value="${user.login}"></c:out>" value = "Remove">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
<form action="${pageContext.servletContext.contextPath}/create.jsp" method="get">
    <button type="submit">Create new user</button>
</form>
</body>
</html>
