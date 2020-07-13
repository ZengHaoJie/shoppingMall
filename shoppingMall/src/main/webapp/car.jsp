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
            width: 150px;
            height: 150px;
        }
        .prosum_box .prosum_right {
            float: left;
            width: 200px;
            margin: 20px 0px 20px 0px;
            padding-left: 20px;
            font-size: 16px;
        }
        .prosum_box .buy{
            float: right;
            font-size: 16px;
            margin-right: 20px;
            margin-top: 140px;
        }

    </style>
    <script>
        function addFun(data) {
            var count = document.getElementById(data);
            var buy = document.getElementById("buy"+data);
            var value = $(count).text();
            value++;
            $.post("carCountServlet",{num:value,gid:data},function () {
                $(count).text(value);
                $(buy).attr("href","/buyServlet?id="+data+"&count="+value);
            })
        }

        function subFun(data) {
            var count = document.getElementById(data);
            var buy = document.getElementById("buy"+data);
            var value = $(count).text();
            if (value <= 1){
                value = 1;
            }else {
                value--;
                $.post("carCountServlet",{num:value,gid:data},function () {})
            }
            $(count).text(value);
            $(buy).attr("href","/buyServlet?id="+data+"&count="+value);
        }

        function delCar(id) {
            if (confirm("确定删除此商品？")){
                location.href = "/deleteServlet?id=" + id;
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center">购物车</h3>
        <a href="/indexServlet" style="float: right;font-size: 16px;">返回首页</a><br>
        <hr>
        <p style="text-align: center">${requestScope.null_msg}</p>
        <c:forEach items="${requestScope.map.keySet()}" var="item">
        <div class="prosum_box">
            <dl class="prosum_left">
                <dt>
                    <img src="/img/${item.gid}.jpg">
                </dt>
            </dl>
            <div class="prosum_right">
                <div>
                    <p >名称  :  <span>${item.gname}</span></p>
                    <p >类型  :  <span>${item.type}</span></p>
                    <p>数量  :
                        <button type="button" class="btn btn-default btn-xs" onclick="addFun(${item.gid});">
                            <span style="padding-bottom: 3px;" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        </button>
                        <span id="${item.gid}">${map.get(item)}</span>
                        <button type="button" class="btn btn-default btn-xs" onclick="subFun(${item.gid});">
                            <span style="padding-bottom: 3px;" class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                        </button>
                    </p>
                </div>
                <div class="pros_price">
                    <strong style="color: red;font-size: 20px;">¥${item.price}</strong>
                </div>
            </div>
            <div  class="buy">
                <a href="javascript:delCar(${item.gid})">删除</a>
                <a id="buy${item.gid}" href="/buyServlet?id=${item.gid}&count=${map.get(item)}">
                    <button type="button" class="btn btn-primary" >立即购买</button>
                </a>
            </div>
        </div>
            <hr>
        </c:forEach>
    </div>
</body>
</html>
