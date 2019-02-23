<!DOCTYPE html>
<html>
<head>
    <title>Login1111</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
    <link href="resources/css/loginStyle.css" rel='stylesheet' type='text/css' />

    <script src="resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<script>$(document).ready(function(c) {
    $('.close').on('click', function(c){
        $('.login-form').fadeOut('slow', function(c){
            $('.login-form').remove();
        });
    });

});
//提交到后台登陆
function login() {
    var userName=$("#userName").val();
    var password=$("#password").val();
    $.ajax({
        type: 'POST',
        url: "/FMC/user/login.do",
        dataType : "JSON",
        data : {
            'username' : userName,'userpwd' : password},
    success : function (data) {
            alert(1111);
    }
    });
}

</script>
<!--SIGN UP-->
<h1>Login</h1>
<div class="login-form">
    <div class="close"> </div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div class="avtar">
        <img src="resources/images/avtar.png" />
    </div>
    <form action="/FMC/user/login.do" method="post">
        <input id="userName" NAME="username" type="text" class="text" value=""  >
        <div class="key">
            <input id="password" name="userpwd" type="password" value="" >
        </div>
        <div class="signin">
            <input type="submit" value="Login">
        </div>
    </form>

</div>
<div class="copy-rights">
    <p>Copyright &copy; 2015.Company name All rights reserved.More Templates - Collect from </p>
</div>

</body>
</html>