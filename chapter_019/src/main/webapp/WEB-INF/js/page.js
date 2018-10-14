$( document ).ready(function() {
    showComments();
});
function showComments() {
    var xhttp = new XMLHttpRequest();
    var id = document.getElementsByName("identifier")[0].value;
    var textComment = document.getElementsByName("textComment")[0].value;
    console.log("text: " + textComment);
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(id);
            console.log(this.responseText);
            json = JSON.parse(this.responseText);
            let result = "";
            let list = document.getElementById("mod");
            for (var i = 0; i!= json.list.length; i++) {
                result += "<div class=\"comments\">";
                result += "<q>" + json.list[i].author + "</q>";
                result += "<div class=\"comment dialog\">";
                result += "<p>" + json.list[i].description + "</p>";
                result += "</div>";
                result += "</div>";
            }
            list.innerHTML = result;
        }
    };
    xhttp.open("GET", "${pageContext.servletContext.contextPath}/comments?id=" + id + "&comment=" + textComment, true);
    xhttp.send();
}