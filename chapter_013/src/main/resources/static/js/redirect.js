function registrationReference() {
    var formData = {
        type : document.getElementsByName("redirect")[0].value,
        longUrl : document.getElementsByName("ref")[0].value
    }
    $.ajax({
        method: "post",
        contentType : "application/json",
        url: "/register",
        data: JSON.stringify(formData),
        dataType : 'json',
        complete: function (msg) {
            console.log(msg);
            json = JSON.parse(msg.responseText);
            var message = json.description;
            alert(message);
        }
    })
    return false;
};