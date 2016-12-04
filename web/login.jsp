<%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/10/27
  Time: 下午7:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请登录固定资产管理系统</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<div style="width: 50%;margin: 0 auto">
    <form role="form" action="LoginServlet" method="post">
        <div class="form-group">
            <label>用户名</label>
            <input type="text" class="form-control" placeholder="username" name="name">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input type="password" class="form-control" placeholder="password" name="password">
        </div>
        <button type="submit" class="btn btn-default btn-lg">确定</button>
    </form>
</div>
</body>
</html>
