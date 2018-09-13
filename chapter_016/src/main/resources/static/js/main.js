function addNewFolder() {
    var val = document.getElementsByName("folder")[0].value;
    $.ajax({
        method: "get",
        url: "/table",
        data: {path: val},
        complete: function (msg) {
            console.log(msg);
            json = JSON.parse(msg.responseText);
            var list = document.getElementById("auto_table");
            var result = "<table class=\"table_advertisements\">";
            result += "<tr>";
            result += "<th>Date</th>";
            result += "<th>Base folder</th>";
            result += "<th>Folders</th>";
            result += "<th>Files</th>";
            result += "<th>All sizes</th>";
            result += "<th> --- </th>";
            result += "</tr>";
            for (var i = 0; i!= json.list.length; i++) {
                result += "<tr>"
                result += "<td>" + json.list[i].created + "</td>";
                result += "<td>" + json.list[i].path + "</td>";
                result += "<td>" + json.list[i].folders + "</td>";
                result += "<td>" + json.list[i].files + "</td>";
                result += "<td>" + json.list[i].size + "</td>";
                result += "<td>";
                result += "<form action=\"/open\" target='_blank' method=\"get\">";
                result += "<input type=\"hidden\" name=\"id\" value=\"" + json.list[i].id + "\">";
                result += "<input type=\"submit\" name=\"Files\" value=\"Файлы\"></form>";
                result += "</td></tr>";
            }
            result += "</table>";
            list.innerHTML = result;
        }
    })
    return false;
}