<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title><c:out value="${current.title}"></c:out>></title>
    <style>
        <%@include file="/WEB-INF/css/page.css"%>
    </style>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        <%@include file="/WEB-INF/js/page.js"%>
    </script>
</head>
<body>
<%--<img src="<c:url value="/green-1072828_1280.jpg"/>" width="600" height="340" align="middle"/>--%>
<h1><c:out value="${current.title}"></c:out></h1><br>
<input type="hidden" id="identifier" name="identifier" value="<c:out value="${current.id}"></c:out>" >
<sf:textarea path="current.text" name="text" cols="150" rows="10" readonly="true"></sf:textarea><br>
<h2>Комментарии: </h2><br>
<div class="my_button" id="mod" data-value="buttonValue">
</div>
<textarea name="textComment" cols="75" rows="5"></textarea><br><br>
<a href="#" class="button7" onclick="showComments()">Add comment</a> <a href="${pageContext.servletContext.contextPath}/news" class="button7">Back</a>
</body>
</html>
