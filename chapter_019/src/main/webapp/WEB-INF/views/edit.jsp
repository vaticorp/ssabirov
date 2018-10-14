<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit/View</title>
    <style>
        <%@include file="/WEB-INF/css/edit.css"%>
    </style>
    <script type="text/javascript">
        <%@include file="/WEB-INF/js/edit.js"%>
    </script>
</head>
<body>
<input type="hidden" id="identifier" name="identifier" value="<c:out value="${current.id}"></c:out>" >
<b>News title:</b> <input type="text" id="title" name="title" value="<c:out value="${current.title}"></c:out>"> <br>
<b>News text:</b><br><textarea id="text" name="text" cols="120" rows="5" maxlength="255"><c:out value="${current.text}"></c:out></textarea><br><br>
<%--<c:forEach items="${current.comments}" var="currentComment">
    <div class="comments">
        <c:out value="${currentComment.author}"></c:out>
        <div class="comment dialog">
            <p><c:out value="${currentComment.description}"></c:out></p>
        </div>
    </div>
</c:forEach>--%>
<%--<textarea name="textComment" cols="75" rows="5"></textarea><br><br>
&lt;%&ndash;<button class="button7" name="addComment" onclick="addNewComment()"> Add comment</button>&ndash;%&gt;
<a href="#" class="button7" onclick="addNewComment()">Add comment</a>--%>

<a href="#" class="button7" onclick="saveChanges()">Save</a> <a href="${pageContext.servletContext.contextPath}/news" class="button7">Back</a>

</body>
</html>