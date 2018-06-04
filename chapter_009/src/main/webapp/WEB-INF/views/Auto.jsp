<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <meta charset="utf-8">
    <title>Вход в систему</title>
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <style>
        <%@include file="/css/style.css"%>
    </style>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        <%@include file="/js/placeholder.js"%>
    </script>
</head>
<body>

<c:if test="${error != ''}">
    <div id="section" style="background-color: red">
        <c:out value="${error}"></c:out>
    </div>
</c:if>

<form id="slick-login" action="${pageContext.servletContext.contextPath}/enter" method="post"
      onsubmit="return validate();">
    <%--@declare id="login"--%>
    <%--@declare id="password"--%>
    <label for='login'>Логин:</label><input type="text" id="lg" name="login" class="placeholder"
                                            placeholder="admin@example.com">
    <label for='password'>Пароль:</label><input type="password" id="ps" name="password" class="placeholder"
                                                placeholder="Сложный пароль...">
    <input type="submit" value="ВОЙТИ">
</form>
</body>
</html>
