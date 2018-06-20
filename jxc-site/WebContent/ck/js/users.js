if (ajax("../api/admins/id", "post", {}, false).data == false) {
    location.href = "login.html"
} else {

}
console.log(ajax("../api/admins/id", "post", {}, false).data)