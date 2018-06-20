var data = ajax("../api/goods/goodslei", "post", {
    "lid": 0,
    "lname": ""
}, false).data
var yuohui = ajax("../api/Service/youhu", "post", {}, false).data

var ghj = new Vue({
    el: "#ghj",
    data: {
        ghjList: data,
    },
    methods: {
        select: function (lid) {
            var pinpai = ajax("../api/Service/pingpai", "post", {"lid": lid}, false);
            ttg.ttgList = pinpai.data;
        }
    }
})


var ttg = new Vue({
    el: "#ttg",
    data: {
        ttgList: yuohui,
        kk: "../ck/images/",
        a: 1
    },
    methods: {
        asdfsd: function (gid, ymoney) {
            alert(gid + "---" + ymoney)
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
})

console.log(ttg.ttgList)

