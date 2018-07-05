function refreshModels() {
    var coun = document.getElementById("brand_name").value ;
    $.ajax({
        method: 'get',
        url: "./json",
        data: {brand: coun},
        complete: function (msg) {
            console.log(msg);
            /*            json = JSON.parse(msg.responseText);
                        var models = document.getElementById("mod");
            /!*          var result = "<p>Model: " +
                            "<select name=\"models\">" +
                            "<option disabled>Check model</option>";
                        for (var i = 0; i!= json.models.length; i++) {
                            result += "<option value=" + json.models[i].id + ">" + json.models[i].name + "</option>";
                        }
                        result += "</select>";
                        result += "</p>";*!/
                        var result = "Модель: <sf:select path='car.model.id'>";
                        result += "<sf:option value='-' label='--Select model'/>";
                        for (var i = 0; i!= json.models.length; i++) {
                            result += "<sf:option value="+ json.models[i].id + " label=" + json.models[i].name+ " />";
                        }
                        result += "</sf:select>";
                        models.innerHTML = result;*/
        }
    })
}

