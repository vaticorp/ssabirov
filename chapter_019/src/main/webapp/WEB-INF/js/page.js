/*$( document ).ready(function()
{
    //console.log("<c:out value=\"${current.title}\"></c:out>");
    //addNewComment(1);
    console.log("enter");
    //here you can call hello function
    /!*$('.my_button').click(function() {
        console.log($(this).attr('data-value'));
    });*!/
});*/
function addNewComment(id) {
    var xhttp = new XMLHttpRequest();
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
    xhttp.open("GET", "${pageContext.servletContext.contextPath}/test?id=" + id, true);
    xhttp.send();
}