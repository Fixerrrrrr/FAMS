<%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/11/1
  Time: 下午7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改资产信息</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="width: 50%;margin: 0 auto">
    请输入要修改的资产信息(不填视为不修改)
    <form role="form" name="asset_update" action="AssetUpdateServlet" method="post">
        <div class="form-group">
            <label>资产编号(必填)</label>
            <input type="text" class="form-control" placeholder="编号" name="assetid">
        </div>
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
            <label>状态</label>
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
