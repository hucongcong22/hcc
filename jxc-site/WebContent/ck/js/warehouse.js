var data = ajax("../api/warehouse/list", "post", {}, false)
var warehouseWrite = new Vue({
    el: "#warehouseWrite",
    data: {
        address: "",
        info: "",
        name: "",
        t1: 0,
        gai: 0,
        id: ""
    },
    watch: {
        name: function (val) {
            var data = ajax("../api/warehouse/names", "post", {"name": this.name}, false).data
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
                var data = ajax("../api/warehouse/write", "post", {
                    "name": this.name,
                    "info": this.info,
                    "address": this.address
                }, false).data
                if (data == true) {
                    alert("商品添加成功")
                    var datas = ajax("../api/warehouse/list", "post", {}, false)
                    warehouse.warehouseList = datas.data
                    warehouseWrite.name = "";
                    warehouseWrite.info = "";
                    warehouseWrite.address = ""
                }
            } else {

            }
        },
        huan: function () {
            this.gai = 0;
            warehouseWrite.name = "";
            warehouseWrite.info = "";
            warehouseWrite.address = ""
        },
        updata: function () {
            var data = ajax("../api/warehouse/updata", "post", {
                "id": this.id,
                "name": this.name,
                "info": this.info,
                "address": this.address
            }, false).data
            if (data == true) {
                alert("商品修改成功")
                var datas = ajax("../api/warehouse/list", "post", {}, false)
                warehouse.warehouseList = datas.data
            }
        }
    }
})


var warehouse = new Vue({
    el: "#warehouse",
    data: {
        warehouseList: data.data
    },
    watch: {},
    methods: {
        deleted: function (x) {
            var data = ajax("../api/warehouse/deleted", "post", {"id": x}, false).data
            if (data == true) {
                alert("商品删除成功")
                var datas = ajax("../api/warehouse/list", "post", {}, false)
                warehouse.warehouseList = datas.data
            }
        },
        updata: function (id, name, address, info) {
            warehouseWrite.name = name;
            warehouseWrite.info = info;
            warehouseWrite.address = address;
            warehouseWrite.id = id;
            warehouseWrite.gai = 1
            warehouseWrite.t1 = 2
        }
    }
})