var data = ajax("../api/goods/goodslei", "post", {
    "lid": 0,
    "lname": ""
}, false).data;

var newGoods = ajax("../api/Service/newGoods", "post", {}, false);
var yuohui = ajax("../api/Service/youhu", "post", {}, false);

var daohang = new Vue({
    el: "#daohang",
    data: {
        goodsleiList: data
    }
});

var xs = new Vue({
    el: "#xs",
    data: {
        goodsboList: newGoods.data,
        kk: "../ck/images/"
    },
    methods: {

        updata: function (gid, ymoney) {

            var userd = ajax("../api/Users/id", "post", {}, false);
            if (userd.data) {
                var tian = ajax("../api/cart/tianjia", "post", {
                    "gid": gid,
                    "shuliang": 1,
                    "zhekou": ymoney,
                    "oderprize": ymoney
                }, false);
                if (tian.data) {
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
            } else {
                location.href = "account.html"
            }

        }
    }
});

var youh = new Vue({
    el: "#youhui",
    data: {
        youhuiList: yuohui.data,
        kk: "../ck/images/"
    },
    methods: {
        shuangji: function (gid, ymoney) {
            var userd = ajax("../api/Users/id", "post", {}, false);
            if (userd.data) {
                var tian = ajax("../api/cart/tianjia", "post", {
                    "gid": gid,
                    "shuliang": 1,
                    "zhekou": ymoney,
                    "oderprize": ymoney
                }, false);
                if (tian.data) {
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
            } else {
                location.href = "account.html"
            }
        }
    }
});
var alltu = ajax("../api/luenbo/all", "post", {}, false);

var luen = new Vue({
    el: "#luern",
    data: {
        photoList: alltu.data,
        kk: "../ck/images/"
    }
});