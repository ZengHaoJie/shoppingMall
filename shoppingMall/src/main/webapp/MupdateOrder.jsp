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
</head>
<body>
<div class="container" style="width: 500px;">
    <h3 style="text-align: center">修改订单</h3>
    <form action="/mUpdateOrderServlet?oid=${requestScope.orders.oid}" method="post" id="subForm">
        <div class="form-group">
            <label for="user">用户ID：</label>
            <input type="text" name="uid" class="form-control" id="user" value="${requestScope.orders.uid}" placeholder="请输入用户ID"/>
        </div>

        <div class="form-group">
            <label for="goods">商品ID：</label>
            <input type="text" name="gid" class="form-control" id="goods" value="${requestScope.orders.gid}" placeholder="请输入商品ID"/>
        </div>

        <div class="form-group">
            <label for="num">购买数量：</label>
            <input type="text" name="num" class="form-control" id="num" value="${requestScope.orders.num}" placeholder="请输入购买数量"/>
        </div>

        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn-primary" type="submit" value="确定">
            <input class="btn btn-primary" type="reset" value="重置">
        </div>
    </form>
</div>
</body>
</html>
