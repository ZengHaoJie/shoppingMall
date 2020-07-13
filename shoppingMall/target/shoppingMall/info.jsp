<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>20170390635曾浩杰</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        .prosum_box {
            width: 750px;
            border: solid 1px #ddd;
            background: #fff;
            overflow: hidden;
            margin: 0 auto 20px;
        }

        .prosum_box .prosum_left {
            margin: 20px;
            overflow: hidden;
            width: 300px;
            float: left;
        }

        .prosum_box .prosum_left img {
            width: 300px;
            height: 300px;
        }
        .prosum_box .prosum_right {
            float: left;
            width: 300px;
            margin: 60px 0px 20px 0px;
            padding-left: 50px;
            font-size: 16px;
        }
        .prosum_box .back{
            float: right;
            margin-right: 20px;
            margin-top: 305px;
            font-size: 16px;
        }

    </style>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center">商品详情</h3>
        <h4 style="text-align: center">${requestScope.car_msg}</h4>
        <div class="prosum_box">
            <dl class="prosum_left">
                <dt>
                    <img src="/img/${requestScope.item.gid}.jpg">
                </dt>
            </dl>
            <div class="prosum_right">
                <div>
                    <p >名称  :  <span>${requestScope.item.gname}</span></p>
                    <p >类型  :  <span>${requestScope.item.type}</span></p>
                    <p >库存量 :  <span>${requestScope.item.count}</span></p>
                </div>
                <div class="pros_price">
                    <strong style="color: red;font-size: 20px;">¥${requestScope.item.price}</strong>
                    <a class="btn" style="font-size: 18px;" href="/addCarServlet?id=${requestScope.item.gid}">
                        <i class="glyphicon glyphicon-shopping-cart" style="margin-right: 5px;"></i>
                        加入购物车
                    </a>
                </div>
                <div style="margin-top: 30px;">
                    <a href="/buyServlet?id=${requestScope.item.gid}&count=1">
                        <button type="button" class="btn btn-primary" >立即购买</button>
                    </a>
                </div>
            </div>
            <div class="back">
                <a href="/indexServlet">返回</a>
            </div>
        </div>
    </div>
</body>
</html>
