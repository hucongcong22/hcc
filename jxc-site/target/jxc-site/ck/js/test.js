var  login =new Vue({
    el:"#login",
    data:{
    },
    methods:{
        login:function () {
            var data=ajax("../api/usersLogin","post",{"tel":"13733502481","password":"123456"},false)
            console.log(data)
        },
        register:function () {
            var data=ajax("../api/users","post",{"tel":"13733509763","password":"123456","type":"1","name":"李佳敏"},false)
            console.log(data)
        },
        select:function () {
            var data=get("../api/users/"+1,"get",{},false)
            console.log(data)
        }
    }
})

var  client =new Vue({
    el:"#client",
    data:{
    },
    methods:{
        write:function () {
            var data=ajax("../api/clientWrite","post",{"name":"李总",
                "vip":"铂金vip",
                "tel":"1525139256",
                "address":"湖北孝感孝南区xx路xx号",
                "principal":"黄经理",
                "companyId":1,
                "accountsId":"1"
            },false)
            console.log(data)
        },
        select:function () {
            var data=get("../api/client","get",{"start":0,"end":5},false)
            console.log(data)
        },
        updata:function () {
            var data=ajax("../api/client","patch",{"id":"2","name":"刘总"},false)
            console.log(data)
        }
    }
})


var  company =new Vue({
    el:"#company",
    data:{
    },
    methods:{
        write:function () {
            var data=ajax("../api/company","post",{
                "name":"武汉爱福泺网络科技有限公司城东分公司",
                "calls":"178987341253",
                "address":"孝感市东城区",
                "tel":"1502417568"
            },false)
            console.log(data)
        },
        updata:function () {
            var data=ajax("../api/company/"+8,"patch",{
                "name":"武汉爱福泺网络科技有限公司孝感分公司",
                "calls":"178987253",
                "address":"孝感市南方国际",
                "tel":"15024517568"
            },false)
            console.log(data)
        }
    }
})



var  warehouse =new Vue({
    el:"#warehouse",
    data:{
    },
    methods:{
        write:function () {
            var data=ajax("../api/warehouse","post",{
                "name":"南方国际东仓",
                "address":"南方国际B2楼0841室"
            },false)
            console.log(data)
        },
        updata:function () {
            var data=ajax("../api/warehouse","patch",{id:1,"name":"南方国际仓库测试办公室"},false)
            console.log(data)
        },
        del:function () {
            var data=ajax("../api/warehouse/"+1,"delete",{},false)
            console.log(data)
        },
        select:function () {
            var data=get("../api/warehouse","get",{},false)
            console.log(data)
        }
    }
})


var  goods =new Vue({
    el:"#goods",
    data:{
    },
    methods:{
        write:function () {
            var data=ajax("../api/goods","post",{
                "name":"小米手机",
                "type":"数码3C",
                "trademark":"小米科技",
                "unit":	"台",
                "unitsGroupId":"10",
                "retailPrice":"2499",
                "combinationPrice":	"2450",
                "purchasingPrice":	"2400",
                "discountType":		"n",
                "remarks":		"此批次机器原装未开封",
                "days":                      "100",
                "warningDays":	 "10",
            },false)
            console.log(data)
        },
        select:function () {
            var data=get("../api/goods/like","get",{"start":0,"end":5,"createTimeStart":"2018-02-21","createTimeEnd":"2018-02-22"},false)
            console.log(data)
        },
        updata:function () {
            var data=ajax("../api/goods","patch",{"id":2,
                "name":"坚果pro2",
                "trademark": "锤子科技",
                "retailPrice":"2299",
                "combination_price":"2250",
                "purchasing_price":	"2200"
            },false)
            console.log(data)
        },
        del:function () {
            var data=ajax("../api/goods/"+2,"delete",{},false)
            console.log(data)
        }
    }
})



var  sales =new Vue({
    el:"#sales",
    data:{
    },
    methods:{
        write:function () {
            var data=ajax("../api/sales","post",{
                "type":'2',	//1-新增销售订单	2-新增销售单
                'money':'100',	//总金额
                'deliveryDay':'2017-12-9',
                'discountsMoney':'100',	//优惠金额
                'clientId':'1',		//客户id
                'operator':"小李",	//操作员
                'payMethod':"支付宝",	//支付方式
                'paid':'5500' ,
                'pay':'6600',
                "state":"1",
                'salesDetail':[
                    {
                        'goodsId':"2",
                        'paid':'2500' ,
                        'pay':'4600',
                        'num':	'5',
                        "numOut":'0',
                        'money_status':"0",
                        'status':0,
                        'discountsPay':'2100',
                        'state':1
                    },
                    {
                        'goodsId':"3",
                        'paid':'3000' ,
                        'pay':'2000',
                        'num':	'2',
                        "numOut":'0',
                        'status':0,
                        'money_status':"0",
                        'discountsPay':'0',
                        'state':1
                    }
                ]
            },false)
            console.log(data)
        },
        updata:function () {
            var data=ajax("../api/sales/"+26,"patch",{
                "type":'2',	//1-新增销售订单	2-新增销售单
                'money':'100',	//总金额
                'deliveryDay':'2017-12-9',
                'discountsMoney':'100',	//优惠金额
                'clientId':'3',		//客户id
                'operator':"胡总",	//操作员
                'payMethod':"微信",	//支付方式
                'paid':'5500' ,
                'pay':'6000',
                "state":"1",
                'salesDetail':[
                    {
                        'goodsId':"3",
                        'paid':'2500' ,
                        'pay':'4600',
                        'num':	'3',
                        "numOut":'0',
                        'moneyStatus':"0",
                        'status':"0",
                        'state':'仓库发货（仓库来源）'
                    },
                    {
                        'goodsId':"2",
                        'paid':'3000' ,
                        'pay':'2000',
                        'num':	'3',
                        "numOut":'0',
                        'status':"0",
                        'moneyStatus':"0",
                        'state':'1'
                    },
                    {
                        'goodsId':"2",
                        'paid':'3000' ,
                        'pay':'2000',
                        'num':	'3',
                        "numOut":'0',
                        'status':"0",
                        'moneyStatus':"0",
                        'state':'仓库发货（仓库来源）'
                    }
                ]
            },false)
            console.log(data)
        },
        tijiao:function () {
            var data=ajax("../api/sales/submit","post",{
                "type":2,
                'money':'100',	//总金额
                'deliveryDay':'2017-12-9',
                'discountsMoney':'100',	//优惠金额
                'clientId':'3',		//客户id
                'operator':"胡总",	//操作员
                'payMethod':"微信",	//支付方式
                'paid':'5500' ,
                'pay':'6000',
                "state":"2",
                'salesDetail':[
                    {
                        'goodsId':"3",
                        'paid':'2500' ,
                        'money':'4600',
                        'num':	'2',
                        "numOut":'0',
                        'moneyStatus':"0",
                        'status':"1",
                        "unitsId":10,
                        "unitsGroupId":15,
                        "warehouseId":2,
                        'state':'1'
                    },
                    {
                        'goodsId':"2",
                        'money':'3000' ,
                        'paid':'2000',
                        'num':	'1',
                        "unitsGroupId":15,
                        "unitsId":11,
                        "numOut":'0',
                        'status':"1",
                        "warehouseId":3,
                        'moneyStatus':"0",
                        'state':'1'
                    }
                ]
            },false)
            console.log(data)
        },
        select:function () {
            var data=get("../api/sales/like","get",{"type":"2","operatorName":"赵"},false)
            console.log(data)
        },
        sum:function(){
            var data=get("../api/sales/sumPay","get",{"type":"1"},false)
            console.log(data)
        },
        shenhe:function () {
            var data=ajax("../api/sales/audit","post",{state: 4, idList: [131,130]},false)
            console.log(data)
        },
        fanshenhe:function () {
            var data=ajax("../api/sales/reverseAudit/"+172,"post",{"state": 2},false)
            console.log(data)
        },
        select1:function () {
            var data=get("../api/sales","get",{"id":132},false)
            console.log(data)
        },
        copy:function () {
            var data=get("../api/sales/copy/"+117,"get",{},false)
            console.log(data)
        },
        deleted:function () {
            var data=ajax("../api/sales/"+133,"delete",{},false)
            console.log(data)
        }
    }
})
