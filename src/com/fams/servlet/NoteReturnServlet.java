package com.fams.servlet;

import com.fams.common.Validate;
import com.fams.dao.AssetInfoDao;
import com.fams.dao.NoteDao;
import com.fams.dao.impl.AssetInfoDaoImpl;
import com.fams.dao.impl.NoteDaoImpl;

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
@WebServlet(name = "NoteReturnServlet")
public class NoteReturnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        int assetid = Integer.parseInt(Validate.validStringNull(request.getParameter("assetid")));
        String returnManagerName = (String)request.getSession().getAttribute("name");
        NoteDao noteDao = new NoteDaoImpl();
        AssetInfoDao assetInfoDao = new AssetInfoDaoImpl();
        PrintWriter out=response.getWriter();

        if(!assetInfoDao.isBorrowed(assetid)){
            out.print("<script type='' language='javascript'>alert('该资产未被借出,不需归还!');location.href='note_return.jsp'; </script>");
            out.flush();
            out.close();
        }
        else {
            int count1 = noteDao.updateReturnInfo(returnManagerName, assetid);
            int count2 = assetInfoDao.updateUserToNull(assetid);

            if (count1 > 0 && count2 > 0) {
                //归还成功
                out.print("<script type='' language='javascript'>alert('资产归还成功!');location.href='note_return.jsp'; </script>");
            } else {
                //归还失败
                out.print("<script type='' language='javascript'>alert('资产归还失败!');history.go(-1); </script>");
            }
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
