package com.fams.servlet;

import com.fams.common.Validate;
import com.fams.dao.ManagerDao;
import com.fams.dao.impl.ManagerDaoImpl;
import com.fams.entity.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by quyuan on 16/10/27.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=gb2312");

        String name = Validate.validStringNull(request.getParameter("name"));
        String password = Validate.validStringNull(request.getParameter("password"));

        Manager manager = new Manager();
        manager.setName(name);
        manager.setPassword(password);
        ManagerDao managerDao = new ManagerDaoImpl();
        if(managerDao.findManager(manager)!=null){
            request.getSession().setAttribute("name",name);
            response.sendRedirect("main.jsp");
        }
        else{
            PrintWriter out=response.getWriter();
            out.print("<script>alert('用户名或密码错误，请重新输入。');history.go(-1);</script>");
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
