<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Объявление</title>
    <style>
        <%@include file="/WEB-INF/css/edit.css"%>
    </style>
</head>
<body>
<h1>Информация по объявлению</h1>
    <c:set var="userID"><c:out value="${userID}"/></c:set>
    Производитель <input class="out" type="text" name="brand" readonly value=<c:out
        value="${advertisement.car.brand.name}"></c:out>> <br/>
    Модель <input class="out" type="text" name="model" readonly value=<c:out value="${advertisement.car.model.name}"></c:out>> <br/>
    Категория <input class="out" type="text" name="model" readonly value=<c:out value="${advertisement.car.category.name}"></c:out>>
    <br/>
    Кузов <input class="out" type="text" name="model" readonly value=<c:out value="${advertisement.car.body.name}"></c:out>> <br/>
    Пробег <input class="out" type="text" name="model" readonly value=<c:out value="${advertisement.car.mileage}"></c:out>> <br/>
    Дата выпуска <input class="out" type="text" name="model" readonly value=<c:out value="${advertisement.car.created}"></c:out>>
    <br/>
    Стоимость <input class="out" type="text" name="model" readonly value=<c:out value="${advertisement.cost}"></c:out>> <br/>
    Продано <input class="out" type="text" name="model" readonly value=<c:out value="${advertisement.soldOut}"></c:out>> <br/>
    <img class="out" src="${pageContext.servletContext.contextPath}/image?id=<c:out value="${advertisement.car.id}"></c:out>"/>
    <c:if test="${advertisement.user.id == userID}">
        <form action="${pageContext.servletContext.contextPath}/edit" method="post">
            <input type="hidden" name="id" value=<c:out value="${advertisement.id}"></c:out>>
            <input type="submit" class="sub" name="Change" value="Изменить статус"><br/>
        </form>
    </c:if>
    <form action="${pageContext.servletContext.contextPath}/list" method="get">
        <input type="submit" class="sub" name="Back" value="Назад">
    </form>

</body>
</html>
