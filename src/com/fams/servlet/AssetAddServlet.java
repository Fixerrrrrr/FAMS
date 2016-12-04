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

/**
 * Created by quyuan on 16/10/28.
 */
@WebServlet(name = "AssetAddServlet")
public class AssetAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        String name = Validate.validStringNull(request.getParameter("name").trim());
        String model = Validate.validStringNull(request.getParameter("model").trim());
        String price_str = Validate.validStringNull(request.getParameter("price").trim());
        String remark = Validate.validStringNull(request.getParameter("remark"));
        String status = Validate.validStringNull(request.getParameter("status"));
        if(name.length()==0||model.length()==0||price_str.length()==0){
            PrintWriter out=response.getWriter();
            out.print("<script>alert('请输入完全信息!');history.go(-1)</script>");
            out.flush();
            out.close();
        }
        else{
            int price = Integer.parseInt(price_str);
            AssetInfo assetInfo = new AssetInfo();
            assetInfo.setName(name);
            assetInfo.setModel(model);
            assetInfo.setPrice(price);
            assetInfo.setRemark(remark);
            assetInfo.setStatus(status);

            AssetInfoDao assetInfoDao = new AssetInfoDaoImpl();
            int count = assetInfoDao.add(assetInfo);
            PrintWriter out=response.getWriter();
            if (count > 0) {
                //添加成功
                out.print("<script type='' language='javascript'>alert('添加成功。');location.href='asset_add.jsp'; </script>");
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
