<%@ page import="java.util.List" %>
<%@ page import="com.fams.entity.StaffInfo" %><%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/10/29
  Time: 下午8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>现有员工</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

    <table class="table table-hover">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>职位</td>
            <td>备注</td>
        </tr>
        <%
            List list = (List)request.getAttribute("staffList");
            for(int i=0;i<list.size();i++){
                StaffInfo staffinfo = (StaffInfo) list.get(i);
        %>
        <tr>
            <td><%=staffinfo.getId()%></td>
            <td><%=staffinfo.getName()%></td>
            <td><%=staffinfo.getPosition()%></td>
            <td><%
                if(staffinfo.getRemark()==null){
                    out.print("");
                }
                else{
                    out.print(staffinfo.getRemark());
                }
            %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
