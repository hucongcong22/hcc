var account = new Vue({
    el: "#account",
    data: {},
    methods: {
        write: function () {
            var data = ajax("../api/account", "post", {"name": "大才哥", "money": "50000"}, false)
            console.log(data)
        },
        updata: function () {
            var data = ajax("../api/account/" + 4, "patch", {"name": "才哥", "money": "4000"}, false)
            console.log(data)
        },
        stop: function () {
            var data = ajax("../api/account/" + 4, "patch", {"state": true}, false)
            console.log(data)
        },
        select: function () {
            var data = get("../api/account", "get", {}, false)
            console.log(data)
        }
    }
})
var worker = new Vue({
    el: "#worker",
    data: {
        "test": 2
    },
    methods: {
        write: function () {
            var data = ajax("../api/worker", "post", {"name": "大才哥", "tel": this.x00}, false)
            console.log(data)
        },
        updata: function () {
            var data = ajax("../api/worker/stopOrStart/" + 1, "patch", {"state": false}, false)
            console.log(data)
        },
        select: function () {
            var data = get("../api/worker", "get", {}, false)
            console.log(data)
        }
    }
})
var money = new Vue({
    el: "#money",
    data: {},
    methods: {
        writePurchase: function () {
            var data = ajax("../api//purchaseDetail/payment/" + 272, "patch", {
                "paid": "200",
                "purchaseId": "26",
                "goodsId": 3
            }, false)
            console.log(data)
        },
        writeSales: function () {
            var data = ajax("../api/salesDetail/receipt/" + 430, "patch", {
                "paid": "200",
                "salesId": "107",
                "goodsId": 3
            }, false)
            console.log(data)
        },
        oughtReceipt: function () {
            var data = get("../api/sales/oughtReceipt", "get", {
                "createTimeStart": "2018-02-23",
                "createTimeEnd": "2018-02-25"
            }, false)
            console.log(data)
        },
        oughtPayment: function () {
            var data = get("../api/purchase/oughtPayment", "get", {
                "createTimeStart": "2018-02-23",
                "createTimeEnd": "2018-02-25",
                "endTimeStart": "2018-02-23",
                "endTimeEnd": "2018-02-25"
            }, false)
            console.log(data)
        },
        deleteOughtReceipt: function () {
            var data = ajax("../api/salesMoneyIn/delete/" + 1, "delete", {"salesBo": [{"id": "117"}, {"id": "106"}]}, false)
            console.log(data)
        },
        deleteOughtPayment: function () {
            var data = ajax("../api/purchaseMoneyOut/delete/" + 1, "delete", {"purchaseBo": [{"id": "55"}, {"id": "26"}]}, false)
            console.log(data)
        },
        finishOughtReceipt: function () {
            var data = ajax("../api/salesMoneyIn/finish/" + 1, "patch", {"salesBo": [{"id": "117"}, {"id": "106"}]}, false)
            console.log(data)
        },
        finishOughtPayment: function () {
            var data = ajax("../api/purchaseMoneyOut/finish/" + 1, "patch", {"purchaseBo": [{"id": "55"}, {"id": "26"}]}, false)
            console.log(data)
        }
    }
})

var units = new Vue({
    el: "#units",
    data: {},
    methods: {
        write: function () {
            var data = ajax("../api/units", "post", {
                "type": 2,
                "name": "个",
                "unitsBo": [{"name": "箱", "weight": "10"}, {"name": "盒", "weight": "2"}]
            }, false)
            console.log(data)
        },
        select: function () {
            var data = get("../api/unitsGroup", "get", {}, false)
            console.log(data)
        }
    }
})

var purchaseStoreOut = new Vue({
    el: "#purchaseStoreOut",
    data: {},
    methods: {
        select: function () {
            var data = get("../api/purchaseStoreOut", "get", {"start": "0", "end": "5"}, false)
            console.log(data)
        },
        selects: function () {
            var data = get("../api/purchaseStoreOut/purchase", "get", {"type": "1"}, false)
            console.log(data)
        }
    }
})


var purchase = new Vue({
    el: "#purchase",
    data: {},
    methods: {
        fahuo: function () {
            var data = ajax("../api/purchase/takeGoods/" + 26, "patch", [{"id": 165, "numOut": 1, "warehouseId": 3},
                {"id": 166, "numOut": 1, "warehouseId": 3}], false)
            console.log(data)
        },
        write: function () {
            var data = ajax("../api/purchase", "post", {
                "type": '2',	//1-新增采购订单	2-新增采购单
                'money': '100',	//总金额
                'deliveryDay': '2017-12-9',
                'discountsMoney': '100',	//优惠金额
                'clientId': '1',		//客户id
                'operator': "小李",	//操作员
                'payMethod': "支付宝",	//支付方式
                'paid': '5500',
                'pay': '6600',
                "state": "1",
                'purchaseDetail': [
                    {
                        'goodsId': "2",
                        'paid': '2500',
                        'pay': '4600',
                        'num': '5',
                        "numOut": '0',
                        'money_status': "0",
                        'status': 0,
                        'discountsPay': '2100',
                        'state': 1
                    },
                    {
                        'goodsId': "3",
                        'paid': '3000',
                        'pay': '2000',
                        'num': '2',
                        "numOut": '0',
                        'status': 0,
                        'money_status': "0",
                        'discountsPay': '0',
                        'state': 1
                    }
                ]
            }, false)
            console.log(data)
        },
        updata: function () {
            var data = ajax("../api/purchase/" + 26, "patch", {
                "type": '2',	//1-新增销售订单	2-新增销售单
                'money': '100',	//总金额
                'deliveryDay': '2017-12-9',
                'discountsMoney': '100',	//优惠金额
                'clientId': '3',		//客户id
                'operator': "胡总",	//操作员
                'payMethod': "支付宝",	//支付方式
                'paid': '5500',
                'pay': '6000',
                "state": "2",
                'purchaseDetail': [
                    {
                        'goodsId': "3",
                        'paid': '2500',
                        'pay': '4600',
                        'num': '3',
                        "numOut": '0',
                        'moneyStatus': "0",
                        'status': "0",
                        'state': '1'
                    },
                    {
                        'goodsId': "2",
                        'paid': '3000',
                        'pay': '2000',
                        'num': '3',
                        "numOut": '0',
                        'status': "0",
                        'moneyStatus': "0",
                        'state': '1'
                    },
                    {
                        'goodsId': "2",
                        'paid': '3000',
                        'pay': '2000',
                        'num': '3',
                        "numOut": '0',
                        'status': "0",
                        'moneyStatus': "0",
                        'state': '1'
                    }
                ]
            }, false)
            console.log(data)
        },
        tijiao: function () {
            var data = ajax("../api/purchase/submit", "post", {
                "type": 2,
                'money': '100',	//总金额
                'deliveryDay': '2017-12-9',
                'discountsMoney': '100',	//优惠金额
                'clientId': '3',		//客户id
                'operator': "胡总",	//操作员
                'payMethod': "微信",	//支付方式
                'paid': '5500',
                'pay': '6000',
                "state": "0",
                'purchaseDetail': [
                    {
                        'goodsId': "3",
                        'paid': '2500',
                        'money': '4600',
                        "num": '2',
                        "unitsType": 1,
                        'moneyStatus': "0",
                        "unitsGroupId": 15,
                        "unitsId": 11,
                        'status': "0",
                        "warehouseId": 2,
                        'state': '1'
                    },
                    {
                        'goodsId': "2",
                        'paid': '3000',
                        'money': '2000',
                        "num": '2',
                        "unitsType": 2,
                        "unitsGroupId": 15,
                        "unitsId": 10,
                        'status': "0",
                        "warehouseId": 3,
                        'moneyStatus': "0",
                        'state': '1'
                    }
                ]
            }, false)
            console.log(data)
        },
        select: function () {
            var data = get("../api/purchase/like", "get", {"type": "2"}, false)
            console.log(data)
        },
        sum: function () {
            var data = get("../api/purchase/sumPay", "get", {"type": ""}, false)
            console.log(data)
        },
        selectov: function () {
            var data = get("../api/purchase/" + 72, "get", {}, false)
            console.log(data)
        },
        deleted: function () {
            var data = ajax("../api/purchase/" + 62, "delete", {}, false)
            console.log(data)
        },
        shenhe: function () {
            var data = ajax("../api/purchase/audit", "post", {
                'purchaseBo': [], "state": 4
            }, false)
            console.log(data)
        },
        copy: function () {
            var data = get("../api/purchase/copy/" + 55, "get", {}, false)
            console.log(data)
        },
    }
})


var supplier = new Vue({
    el: "#supplier",
    data: {},
    methods: {
        write: function () {
            var data = ajax("../api/supplier", "post", {"name": "三星s", "tel": "1354567856", "tel": "000"}, false)
            console.log(data)
        }, select: function () {
            var data = get("../api/supplier/like", "get", {"name": "三"}, false)
            console.log(data)
        }
    }
})

var salesStoreOut = new Vue({
    el: "#salesStoreOut",
    data: {},
    methods: {
        select: function () {
            var data = get("../api/salesStoreOut", "get", {}, false)
            console.log(data)
        },
        selectTime: function () {
            var data = get("../api/salesStoreOut/time", "get", {"salesId": 117, "state": 1}, false)
            console.log(data)
        }
    }
})


var specification = new Vue({
    el: "#specification",
    data: {},
    methods: {
        write: function () {
            var data = ajax("../api/specification", "post", {"type": "颜色", "value": "浅金色", "goodsId": "2"}, false)
            console.log(data)
        },
        del: function () {
            var data = ajax("../api/specification/" + 3, "delete", {}, false)
            console.log(data)
        },
        select: function () {
            var data = get("../api/specification", "get", {}, false)
            console.log(data)
        },
        updata: function () {
            var data = ajax("../api/specification/" + 4, "patch", {"value": "红黑色"}, false)
            console.log(data)
        }
    }
})


var otherStoreInDetail = new Vue({
    el: "#otherStoreInDetail",
    data: {},
    methods: {
        fahuo: function () {
            var data = ajax("../api/sales/deliverGoods/" + 65, "post", [{"id": 406, "numOut": 1}], false)
            console.log(data)
        }
    }
})


var otherStoreIn = new Vue({
    el: "#otherStoreIn",
    data: {},
    methods: {
        write: function () {
            var data = ajax("../api/otherStoreIn", "post", {
                "goods": [{"id": 2, "num": 10}, {"id": 3, "num": 8}],
                "info": "",
                "warehouseId": "3"
            }, false)
            console.log(data)
        }, updata: function () {
            var data = ajax("../api/otherStoreIn/" + 10, "patch", {
                "goods": [{"id": 2, "num": 3}, {"id": 3, "num": 2}],
                "info": "",
                "warehouseId": "3",
                "state": 1
            }, false)
            console.log(data)
        },
        tiojiao: function () {
            var data = ajax("../api/otherStoreIn/" + 10, "patch", {
                "goods": [{"id": 2, "num": 3}, {"id": 3, "num": 2}],
                "info": "",
                "warehouseId": "3",
                "state": 2
            }, false)
            console.log(data)
        },
        shenhe: function () {
            var data = ajax("../api/otherStoreIn/shenhe/" + 10, "patch", {"state": 4}, false)
            console.log(data)
        },
        select: function () {
            var data = get("../api/otherStoreIn", "get", {}, false)
            console.log(data)
        }
    }
})