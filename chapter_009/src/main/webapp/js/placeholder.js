function validate() {
    var result = true;
    var login = document.getElementsByName("login")[0].value;
    var password = document.getElementsByName("password")[0].value;
    if (login == '' || password == '') {
        result = false;
    }
    if (!result) {
        alert("Please, enter login and password!");
    }
    return result;
}