package com.fams.servlet;

import com.fams.common.Validate;
import com.fams.dao.AssetInfoDao;
import com.fams.dao.NoteDao;
import com.fams.dao.StaffInfoDao;
import com.fams.dao.impl.AssetInfoDaoImpl;
import com.fams.dao.impl.NoteDaoImpl;
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
@WebServlet(name = "NoteBorrowServlet")
public class NoteBorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        int assetid = Integer.parseInt(Validate.validStringNull(request.getParameter("assetid")));
        int staffid = Integer.parseInt(Validate.validStringNull(request.getParameter("staffid")));
        String usefor = Validate.validStringNull(request.getParameter("usefor"));
        String remark = Validate.validStringNull(request.getParameter("remark"));
        String borrowManagerName = (String)request.getSession().getAttribute("name");

        NoteDao noteDao = new NoteDaoImpl();
        AssetInfoDao assetInfoDao = new AssetInfoDaoImpl();
        StaffInfoDao staffInfoDao = new StaffInfoDaoImpl();
        PrintWriter out=response.getWriter();
        if(assetInfoDao.isBorrowed(assetid)){
            out.print("<script type='' language='javascript'>alert('该资产还未归还,请先归还!');location.href='note_return.jsp'; </script>");
            out.flush();
            out.close();
        }
        else if(assetInfoDao.findById(assetid).getStatus().equals("维修")){
            out.print("<script type='' language='javascript'>alert('正在维修中,暂无法借出!');location.href='note_borrow.jsp'; </script>");
        }
        else if(assetInfoDao.findById(assetid).getStatus().equals("报废")){
            out.print("<script type='' language='javascript'>alert('该资产已报废,无法借出!');location.href='note_borrow.jsp'; </script>");
        }
        else {
            int count1 = noteDao.insertBorrowInfo(assetid, staffInfoDao.findById(staffid).getName(), borrowManagerName, usefor, remark);
            int count2 = assetInfoDao.updateUser(staffid, assetid);
            if (count1 > 0 && count2 > 0) {
                out.print("<script type='' language='javascript'>alert('资产借出成功!');location.href='note_borrow.jsp'; </script>");
            } else {
                out.print("<script type='' language='javascript'>alert('资产借出失败!');history.go(-1); </script>");
            }
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
