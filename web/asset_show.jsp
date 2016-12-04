<%@ page import="java.util.List" %>
<%@ page import="com.fams.entity.StaffInfo" %>
<%@ page import="com.fams.entity.AssetInfo" %><%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/10/29
  Time: 下午8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>现有资产</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <table class="table table-hover">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>型号</td>
            <td>价格(元)</td>
            <td>状态</td>
            <td>借用者编号</td>
            <td>借用者姓名</td>
            <td>备注</td>
        </tr>
        <%
            List list = (List)request.getAttribute("assetList");
            for(int i=0;i<list.size();i++){
                AssetInfo assetinfo = (AssetInfo)list.get(i);
        %>
        <tr>
            <td><%=assetinfo.getId()%></td>
            <td><%=assetinfo.getName()%></td>
            <td><%=assetinfo.getModel()%></td>
            <td><%=assetinfo.getPrice()%></td>
            <td><%=assetinfo.getStatus()%></td>
            <td><%
                if(assetinfo.getUserid()==0){
                    out.print(" ");
                }
                else{
                    out.print(assetinfo.getUserid());
                }
            %></td>
            <td><%
                if(assetinfo.getUsername()==null){
                    out.print(" ");
                }
                else{
                    out.print(assetinfo.getUsername());
                }
            %></td>
            <td><%
                if(assetinfo.getRemark()==null){
                    out.print(" ");
                }
                else{
                    out.print(assetinfo.getRemark());
                }
            %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
