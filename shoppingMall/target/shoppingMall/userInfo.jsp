<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>20170390635曾浩杰</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">个人信息</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <input type="hidden" name="uid" value="${user.uid}">
        <div class="form-group">
            <label for="username">姓名：</label>
            <input type="text" class="form-control" id="username" name="username" value="${user.username}" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" id="password" name="password" value="${user.password}" placeholder="请输入密码" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender == '男'}">
                <input type="radio" name="gender" value="男" checked />男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
            <c:if test="${user.gender == '女'}">
                <input type="radio" name="gender" value="男"  />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>
        </div>

        <div class="form-group">
            <label for="phone">手机：</label>
            <input type="text" class="form-control" id="phone" value="${user.phone}" name="phone" placeholder="请输入手机号码"/>
        </div>

        <div class="form-group">
            <label for="address">地址：</label>
            <input type="text" class="form-control" id="address" value="${user.address}" name="address" placeholder="请输入籍贯" />
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="/indexServlet"><input class="btn btn-default" type="button" value="返回"/></a>
        </div>
    </form>
</div>
</body>
</html>
