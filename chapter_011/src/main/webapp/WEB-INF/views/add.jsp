<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%--    <script type="text/javascript">
        <%@include file="/WEB-INF/js/create.js"%>
    </script>--%>
    <style>
        <%@include file="/WEB-INF/css/add.css"%>
    </style>
</head>
<body>
<fieldset>
    <legend><b>Добавить новое объявление</b></legend>
    <%--@elvariable id="car" type=""--%>
    <%--enctype="multipart/form-data"--%>
    <sf:form  action="${pageContext.servletContext.contextPath}/create" method="post"  modelAttribute="advertisement">
        <div class="rovno" style="margin: 0px auto; text-align: left;"> <%--onchange="refreshModels()"--%>
               Производитель <sf:select path="car.brand.id" id="brand_name" >
            <sf:option value="-" label="--Select body"/>
            <sf:options items="${brandies}" itemValue="id" itemLabel="name"/>
            </sf:select><br/>
            Модель <sf:select path="car.model.id" >
                <sf:option value="-" label="--Select model"/>
                <sf:options items="${models}" itemValue="id" itemLabel="name"/>
            </sf:select><br/>
            <%--<div id="mod">
            </div>--%>
                <%--placeholder="YYYY-MM-DD hh:mm:ss"--%>
            <p>Дата выпуска: <sf:input path="car.created" type="date" name="created"/> <br/></p>
            <%--<p>Дата выпуска1: <input type="text" placeholder="YYYY-MM-DD hh:mm:ss" name="created"/> <br/></p>--%>
            Кузов: <sf:select  path="car.body.id">
               <sf:option value="-" label="--Select body"/>
               <sf:options items="${bodies}" itemValue="id" itemLabel="name"/>
            </sf:select> <br/><br/>
            Категория: <sf:select path="car.category.id">
               <sf:option value="-" label="--Select category"/>
               <sf:options items="${categories}" itemValue="id" itemLabel="name"/>
            </sf:select> <br/>
            <p>Стоимость: <sf:input type="text" path="cost" name="cost"/> <br/></p>
            <p>Пробег: <sf:input path="car.mileage" type="number" name="mileage" /> <br/></p>
            <sf:input path="user.id" type="test" name="user" hidden="true" value="1"/>
            <p>Загрузите изображение: <sf:input path="car.imageArray" type="file" name="image"/> <br/></p>
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
