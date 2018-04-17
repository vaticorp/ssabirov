<%@ page import="ru.job4j.servletpool.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.job4j.servletpool.UserStore" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border = '2' bgcolor = '#efefef'>
    <% List<User> userList = UserStore.INSTANCE.getUsers(); %>
    <% for (User currentUser : userList) {%>
    <tr>
        <td><%=currentUser.getName()%></td>
        <td><%=currentUser.getLogin()%></td>
        <td><%=currentUser.getEmail()%></td>
        <td>
            <form action="<%=request.getContextPath()%>/edit.jsp?id=<%=currentUser.getLogin()%>" method="post">
                <input type = "submit" name = "<%=currentUser.getLogin()%>" value = "Edit"></form>
        </td>
        <td>
            <form action="<%=request.getContextPath()%>/list" method="post">
                <input type = "submit" name = "<%=currentUser.getLogin()%>" value = "Remove">
            </form>
        </td>
    </tr>
    <%} %>
</table>
<form action="<%=request.getContextPath()%>/create.jsp" method="get">
    <button type="submit">Create new user</button>
</form>
</body>
</html>
