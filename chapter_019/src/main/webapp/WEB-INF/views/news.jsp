<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>News for today</title>
    <style>
        <%@include file="/WEB-INF/css/news.css"%>
    </style>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">News feed</a>
        </div>
        <%--<ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.servletContext.contextPath}/info">Info</a></li>
        </ul>--%>
    </div>
</nav>

<a href="${pageContext.servletContext.contextPath}/add" class="button7">Add news</a><br><hr>

<div id="pagination">
    <c:url value="${pageContext.servletContext.contextPath}/news" var="prev">
        <c:param name="page" value="${page-1}"/>
    </c:url>
    <c:if test="${page > 1}">
        <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
    </c:if>

    <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
        <c:choose>
            <c:when test="${page == i.index}">
                <span class="letter">${i.index}</span>
            </c:when>
            <c:otherwise>
                <c:url value="${pageContext.servletContext.contextPath}/news" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />'>${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:url value="${pageContext.servletContext.contextPath}/news" var="next">
        <c:param name="page" value="${page + 1}"/>
    </c:url>
    <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />' class="pn next">Next</a>
    </c:if><br><br>

    <table>
        <tr>
            <th>Title</th>
            <th>Updated</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${newsList}" var="current">
            <tr>
                <td>
                    <a href='<c:out value="${pageContext.servletContext.contextPath}/news/"/><c:out value="${current.id}"></c:out>'><c:out
                            value="${current.title}"></c:out></a></td>
                <td><c:out value="${current.date}"></c:out></td>
                <td><a href='<c:out value="${pageContext.servletContext.contextPath}/edit/"/><c:out value="${current.id}"></c:out>'>Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
