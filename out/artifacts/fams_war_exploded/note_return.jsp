<%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/10/29
  Time: 下午9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资产归还</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%--资产归还--%>
<%--<form action="NoteReturnServlet" method="post">--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>资产编号</td>--%>
            <%--<td><input type="text" name="assetid"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td></td>--%>
            <%--<td><input type="submit" value="提交"></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>--%>
<div style="width: 50%;margin: 0 auto">
    <form role="form" action="NoteReturnServlet" method="post">
        <div class="form-group">
            <label>资产编号</label>
            <input type="text" class="form-control" placeholder="资产编号" name="assetid">
        </div>
        <button type="submit" class="btn btn-default btn-lg">确定</button>
    </form>
</div>
</body>
</html>
