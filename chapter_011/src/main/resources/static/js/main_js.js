/*$(document).ready ( function(){
    handleFilters();
});*/
function handleFilters() {
    var val = document.getElementsByName("filters")[0].value;
    var brandValue = document.getElementsByName("brand")[0].value;
    document.getElementsByName("brand")[0].hidden = (val != 'by producer');
    $.ajax({
        method: "get",
        url: "/filt",
        data: {filter: val,brand: brandValue},
        complete: function (msg) {
            console.log(msg);
            json = JSON.parse(msg.responseText);
            var list = document.getElementById("mod");
            var result = "<table class=\"table_advertisements\">";
            result += "<tr>";
            result += "<th>Producer</th>";
            result += "<th>Model</th>";
            result += "<th>Category</th>";
            result += "<th>Body</th>";
            result += "<th>Mileage</th>";
            result += "<th>Created</th>";
            result += "<th>Cost(rub)</th>";
            result += "<th>Sold</th>";
            result += "<th>Public</th>";
            result += "<th>Action</th>";
            result += "</tr>";
            for (var i = 0; i!= json.list.length; i++) {
                result += "<tr>"
                result += "<td>" + json.list[i].producer + "</td>";
                result += "<td>" + json.list[i].model + "</td>";
                result += "<td>" + json.list[i].category + "</td>";
                result += "<td>" + json.list[i].body + "</td>";
                result += "<td>" + json.list[i].mileage + "</td>";
                result += "<td>" + json.list[i].created + "</td>";
                result += "<td>" + json.list[i].cost + "</td>";
                result += "<td>" + json.list[i].sold + "</td>";
                result += "<td>" + json.list[i].public + "</td>";
                result += "<td>";
                result += "<form action=\"/files\" method=\"get\">";
                result += "<input type=\"hidden\" name=\"id\" value=\"" + json.list[i].id + "\">";
                result += "<input type=\"submit\" class=\"sub\" name=\"Edit\" value=\"Файлы\"></form>";
                result += "</td></tr>";
            }
            result += "</table>";
            list.innerHTML = result;
        }
    })
}