$(document).ready ( function(){
    refreshTable();
});
function addItem() {
    var desc = document.getElementsByName("description")[0].value;
    if (desc == "") {
        alert("Please, enter item description!");
    } else {
        $.ajax({
            method: 'post',
            url: "./view",
            data: {description: desc}
        })
        refreshTable();
    }
    return false;
};
function finishItem(idTask) {
    $.ajax({
        method: 'post',
        url: "./view",
        data: {idTask: idTask}
    })
    return false;
};
function refreshTable() {
    var cb = document.getElementById("all");
    $.ajax({
        method: 'get',
        url: "./view",
        data: {flag: cb.checked},
        complete: function (msg) {
            console.log(msg.responseText);
            json = JSON.parse(msg.responseText);
            var items_elem = document.getElementById("it");
            var result = "<table border='2' bgcolor='#efefef'>";
            for (var i = 0; i != json.items.length; i++) {
                var d = new Date(json.items[i].created);
                var formattedDate = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear();
                var hours = (d.getHours() < 10) ? "0" + d.getHours() : d.getHours();
                var minutes = (d.getMinutes() < 10) ? "0" + d.getMinutes() : d.getMinutes();
                var formattedTime = hours + ":" + minutes;
                formattedDate = formattedDate + " " + formattedTime;
                result += "<tr>" +
                    /*"<td>" + json.items[i].id + "</td>" +*/
                    "<td>" + json.items[i].desc + "</td>" +
                    "<td>" + formattedDate + "</td>" +
                    "<td>";
                if (json.items[i].done == true) {
                    result +=  "<input type=\"checkbox\" name=\"a\" checked/>";
                } else {
                    result +=  "<input type=\"checkbox\" name=\"a\" onclick='finishItem(" + json.items[i].id + ")' value="+json.items[i].id + "/>";
                }
                result += "</td></tr>";
            }
            result += "</table>";
            items_elem.innerHTML = result;
        }
    })
}
