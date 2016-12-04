package com.fams.servlet;

import com.fams.dao.StaffInfoDao;
import com.fams.dao.impl.StaffInfoDaoImpl;
import com.fams.entity.StaffInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quyuan on 16/10/29.
 */
@WebServlet(name = "StaffSelectServlet")
public class StaffSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        StaffInfoDao staffInfoDao = new StaffInfoDaoImpl();
        ArrayList<StaffInfo> arrayList = staffInfoDao.selectAll();
        request.setAttribute("staffList",arrayList);
        request.getRequestDispatcher("staff_show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
