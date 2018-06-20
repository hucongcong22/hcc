var warehouseData=ajax("../api/warehouse/list","post",{},false)
var storeData=ajax("../api/store/list","post",{},false)
console.log(storeData.data)
var  lan =new Vue({
    el:"#lan",
    data:{
        warehouseList:warehouseData.data,
        storeList:storeData.data,
        goodsName:"",
        goodsId:"",
        warehouseId1:"",
        warehouseId2:"",
        num:""
    },
    watch:{
        goodsName:function () {
            var storeData=ajax("../api/store/list","post",{"goodsName":this.goodsName},false)
            this.storeList=storeData.data
        },
        num:function () {
            var storeData=ajax("../api/store/list","post",{},false).data
            for (var  i=0;i<storeData.length;i++){
                if (storeData[i].goodsId==this.goodsId&&storeData[i].warehouseId==this.warehouseId1){
                    if (this.num>storeData[i].num){
                        alert("最大转移数量为："+storeData[i].num)
                    }
                }
            }
        }
    },
    methods:{
        submit:function () {
            var storeData=ajax("../api/store/list","post",{},false).data
            for (var  i=0;i<storeData.length;i++){
                if (storeData[i].goodsId==this.goodsId&&storeData[i].warehouseId==this.warehouseId1){
                    if (this.num>storeData[i].num){
                        alert("最大转移数量为："+storeData[i].num)
                    }else {
                        var data = ajax("../api/store/add","post",{"goodsId":this.goodsId,"warehouseId":this.warehouseId2,"warehouseId2":this.warehouseId1,"num":this.num},false)
                        if (data.data==true){
                            alert("转移成功")
                            var storeData=ajax("../api/store/list","post",{"goodsName":this.goodsName},false)
                            this.storeList=storeData.data
                        }
                    }
                }
            }
        }
    }
})

