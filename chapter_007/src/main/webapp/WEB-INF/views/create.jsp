<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User list</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: lavenderblush;
        }
        label {
            float:left; padding-right:10px;
        }
        .field {
            clear:both; text-align:right; line-height:25px;
        }
        .main {
            float:left;
        }
    </style>
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
<body>Create new user: <br/>
<div class="main">
    <form action="${pageContext.servletContext.contextPath}/create" method="post">
        <div class="field">
            <p>Login: <input type="text" name="login"> <br/></p>
        </div>
        <div class="field">
            <p>Password:<input type="password" name="password"> <br/></p>
        </div>
        <div class="field">
            <p>Name: <input type="text" name="name"> <br/></p>
        </div>
        <div class="field">
            <p>E-mail:<input type="text" name="email"> <br/></p>
        </div>
        <div class="field">
            <p>Country: <select name="country" onchange="refreshCity()">
                <option disabled selected>Выберите страну</option>
                <c:forEach items="${countries}" var="currentCountry">
                    <option value="<c:out value="${currentCountry}"></c:out>"><c:out
                            value="${currentCountry}"></c:out></option>
                </c:forEach>
            </select>
            </p>
        </div>
        <div id="cit" class="field">
            <p>City: <select name="city">
                <option disabled>Выберите город</option>
            </select>
            </p>
        </div>
        <div class="field">
            <p>role: <select name="role">
                <c:forEach items="${roles}" var="currentRole">
                    <option value="<c:out value="${currentRole.name}"></c:out>"><c:out
                            value="${currentRole.name}"></c:out></option>
                </c:forEach>
            </select>
            </p>
        </div>
        <div class="field">
            <input type="submit" value="Save">
        </div>
    </form>
    <form action="${pageContext.servletContext.contextPath}/" method="get">
        <input type="submit" value="Back">
    </form>
</div>

</body>
</html>
