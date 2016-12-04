package com.fams.servlet;

import com.fams.dao.AssetInfoDao;
import com.fams.dao.impl.AssetInfoDaoImpl;
import com.fams.entity.AssetInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by quyuan on 16/10/29.
 */
@WebServlet(name = "AssetSelectServlet")
public class AssetSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        AssetInfoDao assetInfoDao = new AssetInfoDaoImpl();
        ArrayList<AssetInfo> arrayList = assetInfoDao.selectAll();
        request.setAttribute("assetList",arrayList);
        request.getRequestDispatcher("asset_show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
