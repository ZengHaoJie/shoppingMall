<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>20170390635曾浩杰</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        $(function () {
            var flag = false;
            $("#user").blur(function () {
                var name = $(this).val();
                $.post("jsonServlet",{username:name},function (data) {
                    var span = $("#span");
                    if(data.exist){
                        span.css("color","red");
                        span.html("该用户名不可用");
                    }else{
                        span.css("color","green");
                        span.html("该用户名可用");
                        flag = true;
                    }
                },"json")
            })
            $("#subForm").submit(function () {
                return flag;
            })
        })
    </script>

</head>
<body>
<div class="container" style="width: 400px;margin-top: 50px;">
    <h3 style="text-align: center;">用户注册</h3>
    <form action="/registerServlet" method="post" id="subForm">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
            <span id="span"></span>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="phone">手机：</label>
            <input type="text" name="phone" class="form-control" id="phone" placeholder="请输入手机号"/>
        </div>

        <div class="form-group">
            <label for="address">地址：</label>
            <input type="text" name="address" class="form-control" id="address" placeholder="请输入地址"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn-primary" type="submit" value="注册">
            <input class="btn btn-primary" type="reset" value="重置">
        </div>
    </form>

</div>
</body>
</html>
