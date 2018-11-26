<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Catalog</title>
    <link rel="stylesheet" type="text/css"
          href="http://cdn.sencha.com/ext/gpl/4.2.0/resources/css/ext-all.css">
    <script type="text/javascript" src="http://cdn.sencha.com/ext/gpl/4.2.0/ext-all.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        <%@include file="/WEB-INF/extjs/users.js"%>
    </script>
    <style>
        div #output {
            margin: 400px;
        }
    </style>
    <%--<script type="text/javascript" src="../extjs/books.js"></script>--%>
</head>
<body>
<div id="output"></div>
</body>
</html>