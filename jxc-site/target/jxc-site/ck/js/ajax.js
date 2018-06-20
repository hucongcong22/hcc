

function ajax(url,type,data,async) {//ajax方法
    var  datas;
    $.ajax({
        url: url,
        type: type,
        data: JSON.stringify(data),
        dataType:"json",
        async:async,
        contentType: "application/json"
    }).success(function (data){
        datas=data
    })
    return datas;
}

function get(url,type,data,async) {//ajax方法
    var  datas;
    $.ajax({
        url: url,
        type: type,
        data:data,
        dataType: "json",
        async:async
    }).success(function (data){
        datas=data
    })
    return datas;
}

function ajaxUplod(url,type,formdata){
    var  datas;
    $.ajax({
        url: url,
        type:type,
        data: formdata,
        async: false,
        cache: false,
        processData: false,  // 告诉jQuery不要去处理发送的数据
        contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
        success: function(data){
            datas=data;
        }

    });
    return datas;
}