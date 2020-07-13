<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
</head>
<body>
<div class="container">
    <h3 style="text-align: center">购物商场</h3>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/indexServlet"><strong>类别</strong></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/typeServlet?type=男装">男装</a></li>
                    <li><a href="/typeServlet?type=女装">女装</a></li>
                    <li><a href="/typeServlet?type=运动">运动</a></li>
                    <li><a href="/typeServlet?type=数码">数码</a></li>
                    <li><a href="/typeServlet?type=食品">食品</a></li>
                </ul>
                <form class="navbar-form navbar-right" action="/searchServlet" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索" name="search">
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="/carServlet">购物车</a></li>
                    <li><a href="/orderServlet">我的订单</a></li>
                </ul>
                <strong class="navbar-text navbar-right" style="margin-right: 15px;">欢迎您:<a href="/userInfo.jsp">${sessionScope.user.username}</a></strong>
            </div>

        </div>
    </nav>
    <div class="row">
        <c:forEach items="${requestScope.goods}" var="item">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img width="240px" height="240px" src="/img/${item.gid}.jpg" alt="...">
                    <div class="caption">
                        <h3>${item.gname}</h3>
                        <p style="color: red;font-size: 16px;">￥${item.price}</p>
                        <p><a href="/goodsInfoServlet?id=${item.gid}" class="btn btn-primary" role="button">查看详情</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
