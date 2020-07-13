<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width: 600px;
            border: solid 1px #ddd;
            background: #fff;
            overflow: hidden;
            margin: 0 auto 20px;
        }

        .prosum_box .prosum_left {
            margin: 20px;
            overflow: hidden;
            width: 180px;
            float: left;
        }

        .prosum_box .prosum_left img {
            width: 160px;
            height: 160px;
        }
        .prosum_box .prosum_right {
            float: left;
            width: 200px;
            margin: 20px 0px 20px 0px;
            padding-left: 20px;
            font-size: 14px;
        }
        .prosum_box .buy{
            float: right;
            font-size: 16px;
            margin-right: 25px;
            margin-top: 160px;
        }
    </style>
    <script>
        function delCar(id) {
            if (confirm("确定删除此订单？")){
                location.href = "/deleteOrderServlet?id=" + id;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">我的订单</h3>
    <a href="/indexServlet" style="float: right;font-size: 15px;">返回首页</a>
    <br>
    <hr>
    <c:forEach items="${requestScope.orderMap.keySet()}" var="item">
        <div class="prosum_box">
            <dl class="prosum_left">
                <dt>
                    <img src="/img/${requestScope.orderMap.get(item).gid}.jpg">
                </dt>
            </dl>
            <div class="prosum_right">
                <div>
                    <p>
                        名称  :  <span>${requestScope.orderMap.get(item).gname}</span><br>
                        数量  :  <span>${item.num}</span><br>
                        单价  :  ¥<span>${requestScope.orderMap.get(item).price}</span><br>
                        用户  :  <span>${sessionScope.user.username}</span><br>
                        手机  :  <span>${sessionScope.user.phone}</span><br>
                        地址  :  <span>${sessionScope.user.address}</span>
                    </p>
                </div>
                <div class="pros_price" style="color: red;font-size: 20px;">
                    <strong id="total">¥${item.money}</strong>
                </div>
            </div>
            <div  class="buy">
                <a href="javascript:delCar(${item.oid})">删除</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
