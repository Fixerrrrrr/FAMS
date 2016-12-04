<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 16/11/1
  Time: 上午10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <div>
        <h1 style="font-size: 36px;height: 50px;position: relative;left: 30px">固定资产管理系统</h1>
    </div>
    <div class="self_info" style="position: absolute;top: 10px;right: 30px;">
        <span>欢迎你,
        <%
            out.print(request.getSession().getAttribute("name"));
        %>
        </span>
        <br>
        <span>
            <%
                Date dNow = new Date( );
                SimpleDateFormat ft =
                        new SimpleDateFormat ("yyyy-MM-dd");
                out.print(ft.format(dNow));
            %>
        </span>
    </div>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="main.jsp">首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">固定资产信息管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="AssetSelectServlet">查看现有固定资产</a></li>
                            <li class="divider"></li>
                            <li><a href="asset_add.jsp">添加新的固定资产</a></li>
                            <li><a href="asset_del.jsp">删除现有固定资产</a></li>
                            <li><a href="asset_update.jsp">修改现有固定资产</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">员工信息管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="StaffSelectServlet">查看所有员工</a></li>
                            <li class="divider"></li>
                            <li><a href="staff_add.jsp">添加新的员工</a></li>
                            <li><a href="staff_del.jsp">删除员工</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">资产租借归还 <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="NoteSelectServlet">查看所有记录</a></li>
                            <li class="divider"></li>
                            <li><a href="note_borrow.jsp">资产租借</a></li>
                            <li><a href="note_return.jsp">资产归还</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</header>
</body>
</html>
