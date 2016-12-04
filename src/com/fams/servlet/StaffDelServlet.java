package com.fams.servlet;

import com.fams.common.Validate;
import com.fams.dao.StaffInfoDao;
import com.fams.dao.impl.StaffInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by quyuan on 16/10/30.
 */
@WebServlet(name = "StaffDelServlet")
public class StaffDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        int staffid = Integer.parseInt(Validate.validStringNull(request.getParameter("staffid")));
        StaffInfoDao staffInfoDao = new StaffInfoDaoImpl();
        int count = staffInfoDao.del(staffid);
        PrintWriter out=response.getWriter();
        if (count > 0) {
            //添加成功
            out.print("<script type='' language='javascript'>alert('删除成功。');location.href='staff_del.jsp'; </script>");
        }else{
            //添加失败
            out.print("<script type='' language='javascript'>alert('删除失败。');history.go(-1); </script>");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
