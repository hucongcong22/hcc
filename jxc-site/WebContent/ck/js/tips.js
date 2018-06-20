var data = ajax("../api/goods/goodslei", "post", {
    "lid": 0,
    "lname": ""
}, false).data

for (var i = 0; data.length; i++) {
    $("#lid").append("<option value=" + data[i].lid + ">" + data[i].lname + "</option>");
}


