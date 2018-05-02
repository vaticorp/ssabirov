<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
    <style>
        body {
            background-color: lavenderblush;
        }
        .b_create {
            font-size: 20px;
            border-radius: 10px 10px 10px 10px;
            font-family: "Tahoma";
        }
        .table_price {
            border-collapse: collapse;
            border-left: 3px solid #F79361;
            border-right: 3px solid #F79361;
            border-bottom: 3px solid #F79361;
            font-family: "Lucida Grande", sans-serif;
        }
        .table_price caption {
            background: #F79361;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            padding: 10px;
            box-shadow: 0 2px  4px 0 rgba(0,0,0,.3);
            color: white;
            font-family: "Roboto Slab",serif;
            font-style: normal;
            font-size: 26px;
            text-align: center;
            margin: 0;
        }
        .table_price td, .table_price th {
            padding: 10px;
        }
        .table_price th {
            text-align: left;
            font-size: 18px;
        }
        .table_price tr:nth-child(2n) {
            background: #E5E5E5;
        }
        .table_price td:last-of-type {
            text-align: center;
        }
        .table_price a {
            display: inline-block;
            padding: 5px 10px;
            background: #F79361;
            box-shadow: 2px 2px 0 0 #a22800;
            position: relative;
        }
        .table_price a:hover {
            box-shadow: none;
            top: 2px;
            left: 2px;
        }
    </style>
</head>
<body>
<table class="table_price" border='2' bgcolor='#efefef'>
    Table users: <br/>
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
                    <button class="b_create" type="submit">Create new user</button>
                </form>
            </td>
            <td>
                <form  action="${pageContext.servletContext.contextPath}/roles" method="get">
                    <button class="b_create" type="submit">Edit system roles</button>
                </form>
            </td>
        </tr>
    </table>
</c:if>
</body>
</html>
