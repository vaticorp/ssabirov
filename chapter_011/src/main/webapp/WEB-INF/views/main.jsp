<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

<%--<table class="table_advertisements">
    <tr>
        <th>Производитель</th>
        <th>Модель</th>
        <th>Категория</th>
        <th>Кузов</th>
        <th>Пробег</th>
        <th>Дата выпуска</th>
        <th>Стоимость(руб.)</th>
        <th>Продано</th>
        <th>Дата публикации</th>
        <th>Действие</th>
    </tr>
    <c:forEach items="${advertisements}" var="advertisement">
        <tr>
            <td><c:out value="${advertisement.car.brand.name}"></c:out></td>
            <td><c:out value="${advertisement.car.model.name}"></c:out></td>
            <td><c:out value="${advertisement.car.category.name}"></c:out></td>
            <td><c:out value="${advertisement.car.body.name}"></c:out></td>
            <td><c:out value="${advertisement.car.mileage}"></c:out></td>
            <td><c:out value="${advertisement.car.created}"></c:out></td>
            <td><c:out value="${advertisement.cost}"></c:out></td>
            <td><c:out value="${advertisement.soldOut}"></c:out></td>
            <td><c:out value="${advertisement.publicationDate}"></c:out></td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/edit" method="get">
                    <input type="hidden" name="id" value=<c:out value="${advertisement.id}"></c:out>>
                    <input type="submit" class="sub" name="Edit" value="Просмотр"></form>
            </td>
        </tr>
    </c:forEach>
</table>--%>

<div id="mod">
</div>

<br/>
<img src="<c:url value="/resources/vykup-avto.jpg"/>" width="600" height="340" align="right"/>
<%--<img src="/resources/Logo-Avito.png" />--%>
<form action="${pageContext.servletContext.contextPath}/create" method="get">
    <input type="submit" class="sub" name="Edit" value="Добавить новое объявление"></form>
</body>
</html>
