<%@ page import="ru.job4j.servletpool.model.User" %>
<%@ page import="ru.job4j.servletpool.db.UserStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>User list</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function refreshCity() {
            var coun = document.getElementsByName("country")[0].value;
            $.ajax({
                method: 'post',
                url: "./json",
                data: {country: coun},
                complete: function (msg) {
                    json = JSON.parse(msg.responseText);
                    var cities = document.getElementById("cit");
                    var result = "<p>City: " +
                        "<select name=\"city\">" +
                        "<option disabled>Выберите город</option>";
                    for (var i = 0; i!= json.cities.length; i++) {
                        result += "<option>" + json.cities[i] + "</option>";
                    }
                    result += "</select>";
                    result += "</p>";
                    cities.innerHTML = result;
                }
            })
        }
    </script>
</head>
<body>
Edit current user: <br/>
<c:forEach items="${users}" var="currentUser">
<form action="${pageContext.servletContext.contextPath}/edit" method="get">
    Login: <input type = "text" name = "id" value = "<c:out value="${currentUser.login}"></c:out>"> <br/>
    Name: <input type = "text" name = "name" value = "<c:out value="${currentUser.name}"></c:out>"> <br/>
    E-mail: <input type = "text" name = "email" value = "<c:out value="${currentUser.email}"></c:out>"> <br/>
    <c:if test="${login == 'admin'}">
       Role: <input type = "text" name = "role" value = "<c:out value="${currentUser.role.name}"></c:out>"> <br/>
    </c:if>
    <input type = "submit" value = "Save">
    </form>
</c:forEach>
<form action= "${pageContext.servletContext.contextPath}/" method="get">
    <input type = "submit" value = "back">
    </form>
</body>
</html>
