package com.fams.servlet;

import com.fams.common.Validate;
import com.fams.dao.StaffInfoDao;
import com.fams.dao.impl.StaffInfoDaoImpl;
import com.fams.entity.StaffInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by quyuan on 16/10/29.
 */
@WebServlet(name = "StaffAddServlet")
public class StaffAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        String name = Validate.validStringNull(request.getParameter("name").trim());
        String position = Validate.validStringNull(request.getParameter("position").trim());
        String remark = Validate.validStringNull(request.getParameter("remark"));
        if(name.length()==0||position.length()==0){
            PrintWriter out=response.getWriter();
            out.print("<script>alert('请输入完全信息!');history.go(-1)</script>");
            out.flush();
            out.close();
        }
        else{
            StaffInfo staffInfo = new StaffInfo();
            staffInfo.setName(name);
            staffInfo.setPosition(position);
            staffInfo.setRemark(remark);

            StaffInfoDao staffInfoDao = new StaffInfoDaoImpl();
            int count = staffInfoDao.add(staffInfo);
            PrintWriter out=response.getWriter();
            if (count > 0) {
                //添加成功
                out.print("<script type='' language='javascript'>alert('添加成功。');location.href='staff_add.jsp'; </script>");
            }else{
                //添加失败
                out.print("<script type='' language='javascript'>alert('添加失败。');history.go(-1); </script>");
            }
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
