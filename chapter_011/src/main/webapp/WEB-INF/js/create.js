function refreshModels() {
    var coun = document.getElementsByName("brand")[0].value;
    $.ajax({
        method: 'get',
        url: "./json",
        data: {brand: coun},
        complete: function (msg) {
            console.log(msg);
            json = JSON.parse(msg.responseText);
            var models = document.getElementById("mod");
            var result = "<p>Model: " +
                "<select name=\"models\">" +
                "<option disabled>Check model</option>";
            for (var i = 0; i!= json.models.length; i++) {
                result += "<option value=" + json.models[i].id + ">" + json.models[i].name + "</option>";
            }
            result += "</select>";
            result += "</p>";
            models.innerHTML = result;
        }
    })
}

