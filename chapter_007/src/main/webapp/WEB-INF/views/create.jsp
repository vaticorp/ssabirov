<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User list</title>
</head>
<body>Create new user: <br/>
<form action="${pageContext.servletContext.contextPath}/create" method="post">
    <p>Login: <input type="text" name="login"> <br/></p>
    <p>Password:<input type="password" name="password"> <br/></p>
    <p>Name: <input type="text" name="name"> <br/></p>
    <p>E-mail:<input type="text" name="email"> <br/></p>
    <p>role: <select name="role">
        <c:forEach items="${roles}" var="currentRole">
            <option value="<c:out value="${currentRole.name}"></c:out>"><c:out value="${currentRole.name}"></c:out></option>
        </c:forEach>
    </select>
    </p>
    <input type="submit" value="Save">
</form>
<form action="${pageContext.servletContext.contextPath}/" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>
