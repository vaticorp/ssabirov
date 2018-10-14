function saveChanges() {
    var formData = {
        "id" : document.getElementsByName("identifier")[0].value,
        "title": document.getElementsByName("title")[0].value,
        "text" : document.getElementsByName("text")[0].value
    };
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    };
    xhttp.open("POST", "${pageContext.servletContext.contextPath}/save", true);
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhttp.send(JSON.stringify(formData));
};
