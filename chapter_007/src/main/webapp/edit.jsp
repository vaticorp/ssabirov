<%@ page import="ru.job4j.servletpool.User" %>
<%@ page import="ru.job4j.servletpool.UserStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
Edit current user: <br/> +
<form action="<%=request.getContextPath()%>/edit" method="get">
    <% String login = request.getParameter("id"); %>
    <% User user = UserStore.INSTANCE.getUser(login); %>
    <input type = "text" name = "id" value = "<%=user.getLogin()%> "> <br/>
    <input type = "text" name = "name" value = "<%=user.getName()%>"> <br/>
    <input type = "text" name = "email" value = "<%=user.getEmail()%>"> <br/>
    <input type = "submit" value = "Save">
    </form>
<form action= "<%=request.getContextPath()%>/index.jsp" method="get">
    <input type = "submit" value = "back">
    </form>
</body>
</html>
