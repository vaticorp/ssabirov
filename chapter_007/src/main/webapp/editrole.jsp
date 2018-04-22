<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Edit current role: <br/>
<c:forEach items="${roles}" var="currentRole">
    <form action="${pageContext.servletContext.contextPath}/editrole" method="get">
        <input type = "text" name = "name" value = "<c:out value="${currentRole.name}"></c:out>"disabled> <br/>
        <input type = "text" name = "description" value = "<c:out value="${currentRole.description}"></c:out>"> <br/>
        <input type = "submit" value = "Save">
    </form>
</c:forEach>
<form action= "${pageContext.servletContext.contextPath}/" method="get">
    <input type = "submit" value = "back">
</form>
</body>
</html>
