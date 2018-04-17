<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
</head>
<body>Create new user: <br/>
<form action="<%=request.getContextPath()%>/create" method="post">
    <p>Login: <input type = "text" name = "login"> <br/></p>
    <p>Name:  <input type = "text" name = "name"> <br/></p>
    <p>E-mail:<input type = "text" name = "email"> <br/></p>
    <input type = "submit" value = "Save">
</form>
<form action="<%=request.getContextPath()%>/index.jsp" method="get">
    <input type = "submit" value = "Back">
</form>
</body>
</html>
