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
    <h3 style="text-align: center">修改商品</h3>
    <form action="/mUpdateGoodsServlet?gid=${requestScope.goods.gid}" method="post" id="subForm">
        <div class="form-group">
            <label for="gname">商品名称：</label>
            <input type="text" name="gname" class="form-control" id="gname" value="${requestScope.goods.gname}" placeholder="请输入商品名称"/>
        </div>

        <div class="form-group">
            <label for="price">商品价格：</label>
            <input type="text" name="price" class="form-control" id="price" value="${requestScope.goods.price}" placeholder="请输入商品价格"/>
        </div>

        <div class="form-group">
            <label for="type">商品类型：</label>
            <select id="type" class="form-control" name="type">
                <option selected value="${requestScope.goods.type}">${requestScope.goods.type}</option>
                <option value="男装">男装</option>
                <option value="女装">女装</option>
                <option value="运动">运动</option>
                <option value="数码">数码</option>
                <option value="食品">食品</option>
            </select>
        </div>

        <div class="form-group">
            <label for="count">商品库存：</label>
            <input type="text" name="count" class="form-control" id="count" value="${requestScope.goods.count}" placeholder="请输入商品库存"/>
        </div>
        <hr/>

        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn-primary" type="submit" value="确定">
            <input class="btn btn-primary" type="reset" value="重置">
        </div>
    </form>
</div>
</body>
</html>
