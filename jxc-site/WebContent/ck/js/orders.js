var orders1 = ajax("../api/cart/allding", "post", {}, false);
var orders = new Vue({
    el: "#orders",
    data: {
        at: 0,
        ordersList: orders1.data,
        ordersxiangList: []
    }, methods: {
        dian: function (oid) {
            var odersxing = ajax("../api/cart/xiangping", "post", {"oid": oid}, false)
            if (odersxing.data.length > 0) {
                this.ordersxiangList = odersxing.data;
                this.at = 1;
            }
        },
        xiou: function (oid) {
            var bb = ajax("../api/cart/gaibian", "post", {"oid": oid, "oderstate": "交易取消"}, false)
            if (bb.data) {
                var orde = ajax("../api/cart/allding", "post", {}, false);
                this.ordersList = orde.data;
            }
        }
    }
})