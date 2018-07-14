function registration() {
    var formData = {
        accountID : document.getElementsByName("account")[0].value
    }
    $.ajax({
        method: "post",
        contentType : "application/json",
        url: "/account",
        data: JSON.stringify(formData),
        dataType : 'json',
        complete: function (msg) {
            console.log(msg);
            json = JSON.parse(msg.responseText);
            var message = json.success ? json.description + ". Password: " + json.password : json.description;
            alert(message);
        }
    })
    return false;
}