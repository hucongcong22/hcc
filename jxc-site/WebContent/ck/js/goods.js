var data = ajax("../api/goods/list", "post", {}, false)
var goodsWrite = new Vue({
    el: "#goodsWrite",
    data: {
        type: "",
        units: "",
        name: "",
        t1: 0,
        gai: 0,
        id: ""
    },
    watch: {
        name: function (val) {
            var data = ajax("../api/goods/names", "post", {"name": this.name}, false).data
            if (data == true) {
                this.t1 = 2
            } else {
                this.t1 = 1
            }
        }
    },
    methods: {
        submit: function () {
            if (this.t1 == 2) {
                var data = ajax("../api/goods/write", "post", {
                    "name": this.name,
                    "units": this.units,
                    "type": this.type
                }, false).data
                if (data == true) {
                    alert("商品添加成功")
                    var datas = ajax("../api/goods/list", "post", {}, false)
                    goods.goodsList = datas.data
                    goodsWrite.name = "";
                    goodsWrite.units = "";
                    goodsWrite.type = ""
                }
            } else {

            }
        },
        huan: function () {
            this.gai = 0;
            goodsWrite.name = "";
            goodsWrite.units = "";
            goodsWrite.type = ""
        },
        updata: function () {
            var data = ajax("../api/goods/updata", "post", {
                "id": this.id,
                "name": this.name,
                "units": this.units,
                "type": this.type
            }, false).data
            if (data == true) {
                alert("商品修改成功")
                var datas = ajax("../api/goods/list", "post", {}, false)
                goods.goodsList = datas.data
            }
        }
    }
})


var goods = new Vue({
    el: "#goods",
    data: {
        goodsList: data.data
    },
    watch: {},
    methods: {
        deleted: function (x) {
            var data = ajax("../api/goods/deleted", "post", {"id": x}, false).data
            if (data == true) {
                alert("商品删除成功")
                var datas = ajax("../api/goods/list", "post", {}, false)
                goods.goodsList = datas.data
            }
        },
        updata: function (id, name, type, units) {
            goodsWrite.name = name;
            goodsWrite.units = units;
            goodsWrite.id = id;
            goodsWrite.type = type;
            goodsWrite.gai = 1
            goodsWrite.t1 = 2
        }
    }
})