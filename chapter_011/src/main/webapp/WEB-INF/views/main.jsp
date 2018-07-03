<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Актуально</title>
    <style>
        <%@include file="/WEB-INF/css/mainTable.css"%>
    </style>
    <script type="text/javascript">
        <%@include file="/WEB-INF/js/main.js"%>
    </script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<%--onclick="refreshTable()"--%>
<%--<input type="checkbox" id="last" name="last" /> за последний день
<input type="checkbox" id="photo" name="photo" /> с фото
<input type="checkbox" id="chbrand" name="chbrand" /> по производителю--%>
<body onload="handleFilters()">
<h2>Фильтры: </h2> <select name="filters" onchange="handleFilters()" <%--hidden="false"--%>>
    <option selected>no filter</option>
    <option>last day</option>
    <option>with image</option>
    <option>by producer</option>
</select>

<select name="brand" hidden<%--hidden="false"--%> onchange="handleFilters()">
    <option disabled selected>Выберите производителя</option>
    <c:forEach items="${brandies}" var="currentBrand">
        <option value="<c:out value="${currentBrand.id}"></c:out>"><c:out
                value="${currentBrand.name}"></c:out></option>
    </c:forEach>
</select>
<h1>Активные объявления:</h1><br/>
<div id="mod">
</div>
<br/>
<%--<img src="<c:url value="/templates/image_import/vykup-avto.jpg"/>" width="600" height="340" align="right"/>--%>
<%--<img src="/resources/Logo-Avito.png" />--%>
<sf:form action="${pageContext.servletContext.contextPath}/create" method="get">
<%--    <sf:input path="id" type="text" name="id"/>--%>
    <input type="submit" class="sub" name="Edit" value="Добавить новое объявление">
</sf:form>
</body>
</html>
