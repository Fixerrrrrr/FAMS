package com.fams.servlet;

import com.fams.common.Validate;
import com.fams.dao.AssetInfoDao;
import com.fams.dao.impl.AssetInfoDaoImpl;
import com.fams.entity.AssetInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by quyuan on 16/11/1.
 */
@WebServlet(name = "AssetUpdateServlet")
public class AssetUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        int assetid = Integer.parseInt(request.getParameter("assetid").trim());
        AssetInfoDao assetInfoDao = new AssetInfoDaoImpl();
        AssetInfo assetInfo_up = assetInfoDao.findById(assetid);

        String name = Validate.validStringNull(request.getParameter("name").trim());
        String model = Validate.validStringNull(request.getParameter("model").trim());
        String price_str = Validate.validStringNull(request.getParameter("price").trim());
        String remark = Validate.validStringNull(request.getParameter("remark"));
        String status = Validate.validStringNull(request.getParameter("status"));

        AssetInfo assetInfo = new AssetInfo();
        if (!"".equals(name)) {
            assetInfo.setName(name);
        } else {
            assetInfo.setName(assetInfo_up.getName());
        }
        if (!"".equals(model)) {
            assetInfo.setModel(model);
        } else {
            assetInfo.setModel(assetInfo_up.getModel());
        }
        if (!"".equals(price_str)) {
            int price = Integer.parseInt(price_str);
            assetInfo.setPrice(price);
        } else {
            assetInfo.setPrice(assetInfo_up.getPrice());
        }

        int count1 = assetInfoDao.updateBaseInfo(assetInfo, assetid);
        int count2 = 1;
        int count3 = 1;
        if (!"".equals(remark)) {
            count2 = assetInfoDao.updateRemark(remark, assetid);
        }
        if (!"".equals(status)) {
            count3 = assetInfoDao.updateStatus(status, assetid);
        }
        PrintWriter out = response.getWriter();
        if (count1 > 0 && count2 > 0 && count3 > 0) {
            out.print("<script type='' language='javascript'>alert('修改成功。');location.href='asset_update.jsp'; </script>");
        } else {
            out.print("<script type='' language='javascript'>alert('修改失败。');history.go(-1); </script>");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
