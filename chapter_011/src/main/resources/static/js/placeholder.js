function validate() {
    var result = true;
    var login = document.getElementsByName("login")[0].value;
    var password = document.getElementsByName("password")[0].value;
    if (login == '' || password == '') {
        result = false;
    }
    if (!result) {
        alert("Please, enter login and password!");
    } /*else {
        $.ajax({
            method: 'post',
            url: "./auto",
            data: {name: login, pas: password},
            complete: function (msg) {
/!*                var awnser = JSON.parse(msg.responseText);
                if (awnser.length == 0) {
                    result = false;
                }*!/
            }
        })
    }*/
    return result;
}
