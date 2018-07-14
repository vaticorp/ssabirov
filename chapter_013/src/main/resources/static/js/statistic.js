function show() {
    var val = document.getElementsByName("account")[0].value;
    $.ajax({
        method: "get",
        url: "/statistic/" + val,
        data: {filter: val},
        complete: function (msg) {
            json = JSON.parse(msg.responseText);
            var list = document.getElementById("mod");
            var result = "<table BGCOLOR='#d3d3d3'>";
            result += "<tr>";
            result += "<th>Registered URL</th>";
            result += "<th>Numbers of redirects</th>";
            result += "</tr>";
            for (var i in json) {
                /*console.log( "key: " + i + ", value: " + json[i] );*/
                result += "<tr>"
                result += "<td>" + i + "</td>";
                result += "<td>" + json[i] + "</td>";
                result += "</tr>";
            }
            result += "</table>";
            list.innerHTML = result;
        }
    })
}