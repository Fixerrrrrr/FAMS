<%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/10/29
  Time: 下午7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%--<form name="staff_add" action="StaffAddServlet" method="post">--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>姓名</td>--%>
            <%--<td><input type="text" name="name"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>职位</td>--%>
            <%--<td><input type="text" name="position"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>备注</td>--%>
            <%--<td><textarea name="remark"></textarea></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td></td>--%>
            <%--<td><input type="submit" value="提交"></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>--%>
<div style="width: 50%;margin: 0 auto">
    <form role="form" action="StaffAddServlet" method="post">
        <div class="form-group">
            <label>名称</label>
            <input type="text" class="form-control" placeholder="姓名" name="name">
        </div>
        <div class="form-group">
            <label>职位</label>
            <input type="text" class="form-control" placeholder="职位" name="position">
        </div>
        <div class="form-group">
            <label>备注</label>
            <textarea name="remark" class="form-control" placeholder="备注"></textarea>
        </div>
        <button type="submit" class="btn btn-default btn-lg">确定</button>
    </form>
</div>
</body>
</html>
