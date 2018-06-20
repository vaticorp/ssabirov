<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        <%@include file="/WEB-INF/js/create.js"%>
    </script>
    <style>
        <%@include file="/WEB-INF/css/add.css"%>
    </style>
</head>
<body>
<fieldset>
    <legend><b>Добавить новое объявление</b></legend>
    <%--@elvariable id="car" type=""--%>
    <sf:form enctype="multipart/form-data" action="${pageContext.servletContext.contextPath}/create" method="post" modelAttribute="car">
        <div class="rovno" style="margin: 0px auto; text-align: left;">
            <select name="brand" onchange="refreshModels()">
                <option disabled selected>Выберите производителя</option>
                <c:forEach items="${brandies}" var="currentBrand">
                    <option value="<c:out value="${currentBrand.id}"></c:out>"><c:out
                            value="${currentBrand.name}"></c:out></option>
                </c:forEach>
            </select>
            <div id="mod">
                Модель: <select name="models">
                    <option disabled>Выберите модель</option>
                </select>
            </div>
            Категория: <select name="category">
                <option disabled selected>Выберите категорию</option>
                <c:forEach items="${categories}" var="currentCategory">
                    <option value="<c:out value="${currentCategory.id}"></c:out>"><c:out
                            value="${currentCategory.name}"></c:out></option>
                </c:forEach>
            </select>
            Кузов: <select name="body">
                <option disabled selected>Выберите кузов</option>
                <c:forEach items="${bodies}" var="currentBody">
                    <option value="<c:out value="${currentBody.id}"></c:out>"><c:out
                            value="${currentBody.name}"></c:out></option>
                </c:forEach>
            </select>
            <p>Пробег: <sf:input path="mileage" type="text" name="mileage" /> <br/></p>
            <p>Дата выпуска: <sf:input path="created" type="date" name="created"/> <br/></p>
            <p>Стоимость: <input type="text" required pattern="^[ 0-9]+$" name="cost"> <br/></p>
            <p>Загрузите изображение: <input type="file" name="image"> <br/></p>
            <input type="submit" name="save" value="Сохранить">
        </div>
    </sf:form>
    <form action="${pageContext.servletContext.contextPath}/list" method="get">
        <input type="submit" class="sub" name="Back" value="Назад">
    </form>
</fieldset>
</body>
</body>
</html>
