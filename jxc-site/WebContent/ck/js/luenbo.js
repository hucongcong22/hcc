var alltu = ajax("../api/luenbo/all", "post", {}, false);
var luen = new Vue({
    el: "#luenbo",
    data: {
        photosList: alltu.data,
        sd: "images/"
    },
    methods: {
        delect: function (photoid) {
            var sf = ajax("../api/luenbo/delect", "post", {"photoid": photoid}, false);
            console.log(sf.data)
            if (sf.data) {
                var allt = ajax("../api/luenbo/all", "post", {}, false);
                this.photosList = allt.data;
            }
        },
        tijiao: function () {
            var form = document.getElementById("form1");
            var fd = new FormData(form);
            var sd = $.ajax({
                url: "../api/luenbo/insert",
                type: 'post',
                data: fd,
                async: false,
                cache: false,
                processData: false,  // 告诉jQuery不要去处理发送的数据
                contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
                success: function (data) {
                    var allo = ajax("../api/luenbo/all", "post", {}, false);
                    this.photosList = allo.data;
                }
            })
        }
    }
})