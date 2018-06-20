
$(function(){
    var data=ajax("../api/goods/allshow","post",{"start":0,"end":4,"totalRecord":-1},false);
    var  goodsbo =new Vue({
        el:"#goodsbo",
        data:{
            msg:[],
            start:0,
            end:4,
            fan:0,
            a:0,
            sd:"images/"
        },watch:{
        },
        methods:{
            fa:function (b) {
                if(b>0){
                    this.a=this.a-1;
                }else {
                    this.a=this.a+1;
                }
                this.start=this.a*4;
                this.end=this.a*4+4;
                var fans=data=ajax("../api/goods/allshow","post",{"start":this.start,"end":this.end,"totalRecord":-1},false);
                if(fans.data.length>0&&fans.data.length<5){
                    this.msg=fans.data;
                    this.fan=1;
                }
                else {
                    this.fan=2;
                    if(this.a<=1){
                        this.fan=0;
                    }

                }
            },
            updata:function(gid,gname,ymoney,miao,price){
                goodsX.gai=1;
                goodsX.gid=gid;
                goodsX.gname=gname;
                goodsX.ymoney=ymoney;
                goodsX.miao=miao;
                goodsX.price=price;

            },
            deleted:function (c,b) {
                if(b==1){
                    var xia=ajax("../api/goods/zhuantai","post",{
                        "gid":c,
                        "gstate":"上架"
                    },false);
                    if (xia.data){
                        alert("上架成功");
                    }

                }else {
                    var xia=ajax("../api/goods/zhuantai","post",{
                        "gid":c,
                        "gstate":"下架"
                    },false);
                    if (xia.data){
                        alert("下架成功");
                    }
                }
            }
        }
    })
    goodsbo.msg=data.data;
    var goodsX=new Vue({
        el:"#goodsX",
        data:{
            gid:0,
            gname:"",
            price:"",
            ymoney:0,
            miao:"",
            gai:0,

        },watch:{
        },methods:{
            updata:function () {
                var xiougai=ajax("../api/goods/xiougai","post",{
                    "gaid":this.gid,
                    "ymoney":this.ymoney,
                    "miao":this.miao,
                },false)
                if(xiougai.data){
                    this.gai=0;
                }
            }

        }
    })
})


