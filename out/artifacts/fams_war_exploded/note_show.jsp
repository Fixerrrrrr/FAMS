<%@ page import="java.util.List" %>
<%@ page import="com.fams.entity.Note" %><%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/10/30
  Time: 下午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资产租借归还记录</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<table class="table table-hover">
    <tr>
        <td>编号</td>
        <td>资产编号</td>
        <td>借用者姓名</td>
        <td>借用日期</td>
        <td>借用时管理员</td>
        <td>用途</td>
        <td>归还日期</td>
        <td>归还时管理员</td>
        <td>备注</td>
    </tr>
    <%
        List list = (List)request.getAttribute("noteList");
        for(int i=0;i<list.size();i++){
            Note note = (Note)list.get(i);
    %>
    <tr>
        <td><%=note.getId()%></td>
        <td><%=note.getAssetid()%></td>
        <td><%=note.getStaffName()%></td>
        <td><%=note.getBorrowDate()%></td>
        <td><%=note.getBorrowManagerName()%></td>
        <td><%=note.getUsefor()%></td>
        <td><%
            if(note.getReturnDate()==null){
                out.print("");
            }
            else{
                out.print(note.getReturnDate());
            }
        %></td>
        <td><%
            if(note.getReturnManagerName()==null){
                out.print("");
            }
            else{
                out.print(note.getReturnManagerName());
            }
        %></td>
        <td><%
            if(note.getRemark()==null){
                out.print("");
            }
            else{
                out.print(note.getRemark());
            }
        %></td>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
