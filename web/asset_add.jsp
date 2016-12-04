<%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/10/28
  Time: 下午9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加资产</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="width: 50%;margin: 0 auto">
<form role="form" name="asset_add" action="AssetAddServlet" method="post">
    <div class="form-group">
        <label>名称</label>
        <input type="text" class="form-control" placeholder="名称" name="name">
    </div>
    <div class="form-group">
        <label>型号</label>
        <input type="text" class="form-control" placeholder="型号" name="model">
    </div>
    <div class="form-group">
        <label>价格</label>
        <input type="text" class="form-control" placeholder="价格" name="price">
    </div>
    <div class="form-group">
        <label>状态(默认正常)</label>
        <label class="radio-inline">
            <input type="radio" name="status" id="inlineRadio1" value="正常"> 正常
        </label>
        <label class="radio-inline">
            <input type="radio" name="status" id="inlineRadio2" value="维修"> 维修
        </label>
        <label class="radio-inline">
            <input type="radio" name="status" id="inlineRadio3" value="报废"> 报废
        </label>
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
