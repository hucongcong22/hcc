var goodsdata = ajax("../api/goods/list", "post", {}, false);
var warehousedata = ajax("../api/warehouse/list", "post", {}, false)
var ins = new Vue({
    el: "#ins",
    data: {
        goods: "",
        warehouse: "",
        num: "",
        goodsList: goodsdata.data,
        warehouseList: warehousedata.data
    },
    watch: {},
    methods: {
        submit: function () {
            var data = ajax("../api/store/add", "post", {
                "goodsId": this.goods,
                "warehouseId": this.warehouse,
                "num": this.num
            }, false)
            if (data.data == true) {
                alert("入库成功")
            }
        }
    }
})
