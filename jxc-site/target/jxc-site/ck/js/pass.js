var name =ajax("../api/admins/huq","post",{},false).data
var  pass =new Vue({
    el:"#pass",
    data:{
        name:name,
        password:"",
        newpwd1:"",
        newpwd2:"",
        t1:0,
        t2:0
    },
    watch:{
       password:function(val,oldval){
           var data=ajax("../api/adminsLogin","post",{"aname":name,"apwd":this.password},false)
           if(data.data){
               this.t1=2
           }else {
               this.t1=1
           }
       },
        newpwd2:function (val,oldval) {
            if(this.newpwd2==this.newpwd1){
                this.t2=2
            }else {
                this.t2=1
            }
        }
    },
    methods:{
        submit:function (){
            if(this.t1==2||this.t2==2){
                var data=ajax("../api/admins/xg","post",{"apwd":this.newpwd1},false)
                if (data.data){
                    alert("密码修改成功");
                    this.newpwd1="";
                    this.newpwd2="";
                    this.password="";
                    this.t1=0;
                    this.t2=0;
                }
            }else {
                alert("密码修改失败");

            }
        }
    }
})