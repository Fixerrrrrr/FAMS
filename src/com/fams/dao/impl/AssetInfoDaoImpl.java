package com.fams.dao.impl;

import com.fams.dao.AssetInfoDao;
import com.fams.dao.BaseDao;
import com.fams.dao.StaffInfoDao;
import com.fams.entity.AssetInfo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by quyuan on 16/7/12.
 */
public class AssetInfoDaoImpl extends BaseDao implements AssetInfoDao {
    @Override
    public int add(AssetInfo assetInfo) {
        String sql = "INSERT INTO assetinfo (name,model,price,status,remark) VALUES (?,?,?,?,?)";
        Object[] param = {assetInfo.getName(), assetInfo.getModel(), assetInfo.getPrice(), assetInfo.getStatus(), assetInfo.getRemark()};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int del(int id) {
        String sql = "DELETE FROM assetinfo WHERE id = ?";
        Object[] param = {id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int updateBaseInfo(AssetInfo assetInfo, int id) {
        String sql = "UPDATE assetinfo SET name=?,model=?,price=? WHERE id = ?";
        String name = assetInfo.getName();
        String model = assetInfo.getModel();
        int price = assetInfo.getPrice();
        Object[] param = {name, model, price, id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int updateStatus(String status, int id) {
        String sql = "UPDATE assetinfo SET status = ? WHERE id=?";
        Object[] param = {status, id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int updateUser(int userid, int id) {
        String sql = "UPDATE assetinfo SET userid = ?,username = ? WHERE id =?";
        StaffInfoDao staffInfoDao = new StaffInfoDaoImpl();
        Object[] param = {userid, staffInfoDao.findById(userid).getName(), id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int updateUserToNull(int id) {
        String sql = "UPDATE assetinfo SET userid = null,username = null WHERE id =?";
        Object[] param = {id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int updateRemark(String remark, int id) {
        String sql = "UPDATE assetinfo SET remark = ? WHERE id =?";
        Object[] param = {remark,id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }


    @Override
    public AssetInfo findById(int id) {
        String sql = "SELECT * FROM assetinfo WHERE id = ?";
        Object[] param = {id};
        ResultSet rs = this.executeQuery(sql, param);
        AssetInfo assetInfo = null;
        try {
            if (rs.next()) {
                assetInfo = new AssetInfo();
                assetInfo.setId(id);
                assetInfo.setName(rs.getString("name"));
                assetInfo.setModel(rs.getString("model"));
                assetInfo.setPrice(rs.getInt("price"));
                assetInfo.setUserid(rs.getInt("userid"));
                assetInfo.setStatus(rs.getString("status"));
                assetInfo.setUsername(rs.getString("username"));
                assetInfo.setRemark(rs.getString("remark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return assetInfo;
    }

    @Override
    public ArrayList<AssetInfo> selectAll() {
        String sql = "SELECT * FROM assetinfo";
        ArrayList<AssetInfo> assetInfos = new ArrayList<AssetInfo>();
        ResultSet rs = this.executeQuery(sql);
        AssetInfo assetInfo = null;
        try {
            while (rs.next()) {
                assetInfo = new AssetInfo();
                assetInfo.setId(rs.getInt("id"));
                assetInfo.setName(rs.getString("name"));
                assetInfo.setModel(rs.getString("model"));
                assetInfo.setPrice(rs.getInt("price"));
                assetInfo.setUserid(rs.getInt("userid"));
                assetInfo.setStatus(rs.getString("status"));
                assetInfo.setUsername(rs.getString("username"));
                assetInfo.setRemark(rs.getString("remark"));
                assetInfos.add(assetInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return assetInfos;
    }



    @Override
    public boolean isBorrowed(int id) {
        AssetInfoDao assetInfoDao = new AssetInfoDaoImpl();
        AssetInfo assetInfo = assetInfoDao.findById(id);
        if (assetInfo.getUserid() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
