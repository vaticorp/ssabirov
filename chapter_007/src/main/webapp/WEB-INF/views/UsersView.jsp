<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<table border='2' bgcolor='#efefef'>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.role.name}"></c:out></td>
            <c:choose>
                <c:when test="${login eq 'admin'}">
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/edit?id=<c:out value="${user.login}"></c:out>"
                              method="post">
                            <input type="submit" name="<c:out value="${user.login}"></c:out>" value="Edit(adm)"></form>
                    </td>
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/list" method="post">
                            <input type="submit" name="<c:out value="${user.login}"></c:out>" value="Remove(adm)">
                        </form>
                    </td>
                </c:when>
                <c:when test="${login eq user.login}">
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/edit?id=<c:out value="${user.login}"></c:out>"
                              method="post">
                            <input type="submit" name="<c:out value="${user.login}"></c:out>" value="Edit"></form>
                    </td>
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/list" method="post">
                            <input type="submit" name="<c:out value="${user.login}"></c:out>" value="Remove">
                        </form>
                    </td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>
<c:if test="${login == 'admin'}">
    <table>
        <tr>
            <td>
                <form action="${pageContext.servletContext.contextPath}/create" method="get">
                    <button type="submit">Create new user</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/roles" method="get">
                    <button type="submit">Edit system roles</button>
                </form>
            </td>
        </tr>
    </table>
</c:if>
</body>
</html>
