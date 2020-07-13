<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h3 style="text-align: center">修改用户</h3>
    <form action="/mUpdateUserServlet?uid=${requestScope.updateUser.uid}" method="post" id="subForm">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" value="${requestScope.updateUser.username}" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" name="password" class="form-control" id="password" value="${requestScope.updateUser.password}" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label>管理权限：</label>
            <c:if test="${requestScope.updateUser.manage == '0'}">
                <input type="radio" name="manage" value="0" checked="checked"/>无
                <input type="radio" name="manage" value="1"/>有
            </c:if>
            <c:if test="${requestScope.updateUser.manage == '1'}">
                <input type="radio" name="manage" value="0"/>无
                <input type="radio" name="manage" value="1" checked="checked"/>有
            </c:if>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${requestScope.updateUser.gender == '男'}">
                <input type="radio" name="gender" value="男" checked />男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
            <c:if test="${requestScope.updateUser.gender == '女'}">
                <input type="radio" name="gender" value="男"  />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>
        </div>

        <div class="form-group">
            <label for="phone">手机：</label>
            <input type="text" name="phone" class="form-control" id="phone" value="${requestScope.updateUser.phone}" placeholder="请输入手机号"/>
        </div>

        <div class="form-group">
            <label for="address">地址：</label>
            <input type="text" name="address" class="form-control" id="address" value="${requestScope.updateUser.address}" placeholder="请输入地址"/>
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
