package com.fams.servlet;

import com.fams.common.Validate;
import com.fams.dao.AssetInfoDao;
import com.fams.dao.impl.AssetInfoDaoImpl;

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
@WebServlet(name = "AssetDelServlet")
public class AssetDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        int assetid = Integer.parseInt(Validate.validStringNull(request.getParameter("assetid")));
        AssetInfoDao assetInfoDao = new AssetInfoDaoImpl();
        PrintWriter out=response.getWriter();
        if(assetInfoDao.isBorrowed(assetid)){
            out.print("<script type='' language='javascript'>alert('请先归还!');location.href='note_return.jsp'; </script>");
            out.flush();
            out.close();
        }
        else {
            int count = assetInfoDao.del(assetid);
            if (count > 0) {
                out.print("<script type='' language='javascript'>alert('删除成功。');location.href='asset_del.jsp'; </script>");
            } else {
                out.print("<script type='' language='javascript'>alert('删除失败。');history.go(-1); </script>");
            }
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
