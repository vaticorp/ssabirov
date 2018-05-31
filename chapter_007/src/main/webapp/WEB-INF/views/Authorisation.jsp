<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: cornsilk;
        }
        .buttons {
            font-size: 20px;
            border-radius: 10px 10px 10px 10px;
            font-family: "Tahoma";
        }
        .all {
            display: block;
            width: 200px;
            -webkit-box-sizing:content-box;
            -moz-box-sizing:content-box;
            -ms-box-sizing:content-box;
            box-sizing:content-box;
        }
    </style>
    <script>
        function validate() {
            var result = true;
            var login = document.getElementsByName("login")[0].value;
            var password = document.getElementsByName("password")[0].value;
            if (login == '' || password == '') {
                result = false;
            }
            if (!result) {
                alert("Please, enter correct  login and password!");
            } else {
                $.ajax({
                    method: 'get',
                    url: "./json",
                    data: {name: login, pas: password},
                    complete: function (msg) {
                        var awnser = JSON.parse(msg.responseText);
                        if (awnser.length == 0) {
                            result = false;
                        }
                    }
                })
            }
            return result;
        }
    </script>
</head>
<body>
<p1>Enter the system:</p1> <br/><br/>
<c:if test="${error != ''}">
    <div id="section" style="background-color: blue">
       <c:out value="${error}"></c:out>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/" method="get" onsubmit="return validate();">
    <p2>Login: <input id="lg" class="all" type = "text" name = "login"> <br/></p2>
    <p2>Password:  <input id="ps" class="all" type = "password" name = "password"> <br/></p2>
    <input class="buttons" type = "submit" value = "log-on">
</form>
</body>
</html>
