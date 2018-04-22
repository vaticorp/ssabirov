<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border='2' bgcolor='#efefef'>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td><c:out value="${role.name}"></c:out></td>
            <td><c:out value="${role.description}"></c:out></td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/editrole?name=<c:out value="${role.name}"></c:out>"
                      method="post">
                    <input type="submit" name="<c:out value="${role.name}"></c:out>" value="Edit role"></form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.servletContext.contextPath}/" method="get">
    <input type = "submit" value = "Back">
</form>
</body>
</html>
