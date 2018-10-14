function saveChanges() {
    //document.getElementsByName("identifier")[0].value
    var formData = {
        "id" : document.getElementsByName("identifier")[0].value,
        "title": document.getElementsByName("title")[0].value,
        "text" : document.getElementsByName("text")[0].value
    };
/*    var data = {};
    data.id = "25";
    data.title  = "test1";
    data.text  = "test2";
    var json = JSON.stringify(data);*/
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    };
    xhttp.open("POST", "${pageContext.servletContext.contextPath}/save", true);
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    //xhttp.setRequestHeader("Content-Type", "application/json");
    //xhttp.setRequestHeader("Accept", "application/json");
    //JSON.stringify(formData)
    xhttp.send(JSON.stringify(formData));
};
