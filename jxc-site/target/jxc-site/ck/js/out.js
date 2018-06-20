var data =ajax("../api/store/allList","post",{},false);
console.log(data)
var  out =new Vue({
    el:"#out",
    data:{
        goods:"",
        warehouse:"",
        num:"",
        nums:0,
        goodsList:data.data.goods,
        warehouseList:data.data.warehouses,
        t1:0
    },
    watch:{
        num:function (){
            var data = ajax("../api/store/num","post",{"goodsId":this.goods,"warehouseId":this.warehouse},false)
            this.nums=data.data
            this.t1=1
        }
    },
    methods:{
        submit:function () {
            if (this.num<=this.nums){
                var data = ajax("../api/store/out","post",{"goodsId":this.goods,"warehouseId":this.warehouse,"num":this.num},false)
                if (data.data==true){
                    alert("出库成功")
                    var data =ajax("../api/store/allList","post",{},false);
                    this.goodsList=data.data.goods
                    this.warehouseList=data.data.warehouses
                    var data = ajax("../api/store/num","post",{"goodsId":this.goods,"warehouseId":this.warehouse},false)
                    this.nums=data.data
                    this.t1=1
                }else {
                    alert("此仓库已无此商品库存")
                }
            }else {
                alert("出库数量不能大于库存")
            }
        }
    }
})
