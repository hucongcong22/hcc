var  login =new Vue({
    el:"#login",
    data:{
        name:"",
        password:""
    },
    methods:{
        login:function (){
            var data=ajax("../api/adminsLogin","post",{"aname":this.name,"apwd":this.password},false)
            console.log(data)
            if (data.data){
                location.href="index.html"
            }else {
                alert("用户名或密码错误")
            }
        }
    }
})