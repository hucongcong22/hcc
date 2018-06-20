var cat = new Vue({
    el: "#cat",
    data: {
        odersxiangList: [],
        shuliang: 0,
        kk: "../ck/images/"
    }, methods: {
        delect: function (oderid) {
            var dele = ajax("../api/cart/delect", "post", {"oderid": oderid}, false);
            if (dele.data == "asas") {
                shuaxin();
            }

        }

    }
})

var jie = new Vue({
    el: "#jie",
    data: {
        oderList: [],
        oid: 0,
    },
    methods: {
        jisuan: function () {
            var jiesuan = ajax("../api/cart/jieshuan", "post", {"oid": this.oid}, false);
            if (jiesuan.data) {
                alert("结算成功");
                shuaxin();
            }
        }
    }
})


function shuaxin() {
    var oders = ajax("../api/cart/ding", "post", {}, false);

    jie.oderList = oders.data;
    console.log(jie.oderList.length)
    for (var i = 0; i < jie.oderList.length; i++) {
        jie.oid = jie.oderList[i].oid;
    }
    var orders = ajax("../api/cart/xiangping", "post", {"oid": jie.oid}, false);
    console.log(orders.data);
    if (orders.data.length == 0) {
        alert("购物者空空如也，去购物吧");
        location.href = "index.html"
    }
    cat.odersxiangList = orders.data;


}

$(function () {
    shuaxin();
})