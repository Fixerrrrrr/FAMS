<%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/10/30
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除员工</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="width: 50%;margin: 0 auto">
    <form role="form" action="StaffDelServlet" method="post">
        <div class="form-group">
            <label>员工编号</label>
            <input type="text" class="form-control" placeholder="资产编号" name="staffid">
        </div>
        <button type="submit" class="btn btn-default btn-lg">确定</button>
    </form>
</div>
    <%--<script>--%>
        <%--var td4list = document.getElementsByTagName("tr");--%>
        <%--for(var i=0;i<td4list.length;i++){--%>
            <%--var newtr = document.createElement("tr");--%>
            <%--var newinput = document.createElement("input");--%>
            <%--newinput.setAttribute("type","button");--%>
            <%--newinput.setAttribute("value","删除");--%>
            <%--&lt;%&ndash;newinput.onclick=location.href("StaffDelServlet?id=<%=id%>");&ndash;%&gt;--%>
            <%--newtr.appendChild(newinput);--%>
            <%--td4list.item(i).appendChild(newtr);--%>
            <%--td4list.item(i).appendChild()--%>
        <%--}--%>
    <%--</script>--%>
</body>
</html>
