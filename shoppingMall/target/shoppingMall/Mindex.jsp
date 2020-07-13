<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <style>
        .jumbotron{
            width: 350px;
            float: left;
            margin-left: 25px;
        }
        .jumbotron p{
            font-size: 18px;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center;">管理系统</h3>
    <hr>
    <div class="jumbotron">
        <h3>用户管理</h3>
        <p>用户的增加、删除、修改</p>
        <p><a class="btn btn-primary btn-lg" href="/mFindAllUserServlet" role="button">用户管理</a></p>
    </div>
    <div class="jumbotron">
        <h3>商品管理</h3>
        <p>商品的发布、删除、修改</p>
        <p><a class="btn btn-primary btn-lg" href="/mFindAllGoodsServlet" role="button">商品管理</a></p>
    </div>
    <div class="jumbotron">
        <h3>订单管理</h3>
        <p>订单的增加、删除、修改</p>
        <p><a class="btn btn-primary btn-lg" href="/mFindAllOrderServlet" role="button">订单管理</a></p>
    </div>
</div>
</body>
</html>
