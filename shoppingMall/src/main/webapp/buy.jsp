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
        $(function () {
            $("#total").text((${requestScope.item.price * requestScope.count}).toFixed(2));
        })

        function buy() {
            var money = $("#total").text();
            var num = $("#num").text();
            if (confirm("购买"+num+"件，共需付款"+money+"元，确定下单吗？")){
                <%--location.href = "/addOrderServlet?num="+num+"&money="+money+"&gid="+${requestScope.item.gid};--%>
                $.post("addOrderServlet",{"num":num,"money":money,"gid":${requestScope.item.gid}},function (data) {
                    if (data.exist){
                        alert("购买成功")
                        location.href = "/orderServlet";
                    }else {
                        alert("库存不够，购买失败")
                    }
                },"json")
            }
        }

        function addFun() {
            var num = $("#num").text();
            num++;
            $("#num").text(num);
            $("#total").text((num * ${requestScope.item.price}).toFixed(2));
        }

        function subFun() {
            var num = $("#num").text();
            if (num <= 1){
                num = 1;
            }else {
                num--;
            }
            $("#num").text(num);
            $("#total").text((num * ${requestScope.item.price}).toFixed(2));
        }
    </script>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center">商品购买</h3>
        <a href="/indexServlet" style="float: right;font-size: 15px;">返回首页</a>
        <a href="/carServlet" style="float: right;font-size: 15px;margin-right: 15px;">返回购物车</a>
        <br>
        <hr>
        <div class="prosum_box">
            <dl class="prosum_left">
                <dt>
                    <img src="/img/${requestScope.item.gid}.jpg">
                </dt>
            </dl>
            <div class="prosum_right">
                <div>
                    <p >名称  :  <span>${requestScope.item.gname}</span></p>
                    <p >库存  :  <span>${requestScope.item.count}</span></p>
                    <p>数量  :
                        <button type="button" class="btn btn-default btn-xs" onclick="addFun();">
                            <span style="padding-bottom: 3px;" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        </button>
                        <span id="num">${requestScope.count}</span>
                        <button type="button" class="btn btn-default btn-xs" onclick="subFun();">
                            <span style="padding-bottom: 3px;" class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                        </button>
                    </p>
                    <p>单价  :  ¥<span>${requestScope.item.price}</span></p>
                </div>
                <div class="pros_price" style="color: red;font-size: 20px;">
                    <strong>￥</strong>
                    <strong id="total">¥0.00</strong>
                </div>
            </div>
            <div  class="buy">
                <a href="javascript:buy()">
                    <button type="button" class="btn btn-primary" >下单</button>
                </a>
            </div>
        </div>
    </div>
</body>
</html>
