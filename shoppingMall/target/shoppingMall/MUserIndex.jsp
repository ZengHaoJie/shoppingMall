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
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            if (confirm("你确定删除吗?")) {
                location.href = "/mDelUserServlet?id=" + id;
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center">用户信息列表</h3>
        <hr>
        <div style="float: right;margin: 5px;">
            <a class="btn btn-primary" href="/MaddUser.jsp">添加用户</a>
            <a class="btn btn-primary" href="/Mindex.jsp">返回首页</a>
        </div>
        <div>
            <table border="1" class="table table-bordered table-hover">
                <tr class="success">
                    <th>用户ID</th>
                    <th>姓名</th>
                    <th>密码</th>
                    <th>管理权限</th>
                    <th>性别</th>
                    <th>手机号</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${requestScope.userList}" var="user">
                    <tr>
                        <td>${user.uid}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.manage}</td>
                        <td>${user.gender}</td>
                        <td>${user.phone}</td>
                        <td>${user.address}</td>
                        <td>
                            <a class="btn btn-default btn-sm"
                               href="/mFindUserByIdServlet?id=${user.uid}">修改</a>&nbsp;
                            <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.uid})">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
