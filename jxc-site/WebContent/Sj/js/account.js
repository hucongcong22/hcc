var userss = new Vue({
    el: "#userss",
    data: {
        a: 0,
        uname: "",
        uname1: "",
        upwd: "",
        upwd1: "",
        password: "",
        address: "",
        contact: "",
        t1: 0,
        t2: 0,
        t3: 0,
        t4: 0,
    },
    watch: {
        uname1: function () {
            var un = ajax("../api/users/congmin", "post", {"uname": this.uname1}, false);
            if (un.data) {
                this.t1 = 2;
            } else {
                this.t1 = 1;
            }
        },
        upwd1: function (val, oldval) {
            if (this.upwd1 == this.password) {
                this.t2 = 0;
            } else {
                this.t2 = 1;
            }
        },
        address: function (val, oldval) {
            if (this.address.length != 0) {
                this.t3 = 0;
            } else {
                this.t3 = 1;
            }
        },
        contact: function (val, oldval) {
            if (this.contact.length == 11) {
                this.t4 = 0;
            } else {
                this.t4 = 1;
            }

        }
    },
    methods: {
        dianji: function (sb) {
            this.a = sb;
        },
        insert: function () {
            if (this.t1 == 2 && this.t2 == 0 && this.t3 == 0 && this.t4 == 0) {
                var zuce = ajax("../api/users/registered", "post", {
                    "uname": this.uname1,
                    "upwd": this.upwd1,
                    "address": this.address,
                    "contact": this.contact
                }, false);
                if (zuce.data) {
                    alert("注册成功");
                    window.history.go(-1);
                } else {
                    alert("注册失败");
                    this.uname1 = "";
                    this.upwd1 = "";
                    this.password = "";
                    this.address = "";
                    this.contact = "";
                }
            } else {
                alert("请认真填写");
            }
        },
        login: function () {
            var lg = ajax("../api/usersLogin", "post", {
                "uname": this.uname,
                "upwd": this.upwd,
            }, false);
            if (lg.data) {
                alert("登陆成功");
            } else {
                alert("登陆失败");
            }
        }
    }
})