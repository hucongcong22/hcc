var uname=ajax("../api/users/uname","post",{},false);
console.log(uname.data);
var ren=new Vue({
    el:"#ren",
    data:{
        as:0,
        uname:"",
    },
    methods:{
        dianjia:function () {
            var userd=ajax("../api/Users/id","post",{},false)
            if(userd.data){
                location.href="cart.html"
            }else {
                location.href="account.html"
            }
        }
    }
})
$(function () {
    console.log(uname.data!= null)
    if(uname.data!= null){
        ren.as=1;
        ren.uname=uname.data;
    }
})