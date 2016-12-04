package com.fams.dao.impl;

import com.fams.dao.BaseDao;
import com.fams.dao.StaffInfoDao;
import com.fams.entity.StaffInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by quyuan on 16/7/12.
 */
public class StaffInfoDaoImpl extends BaseDao implements StaffInfoDao {
    @Override
    public ArrayList<StaffInfo> findByName(String name) {
        String sql = "SELECT * FROM staffinfo WHERE name=?";
        Object[] param = {name};
        StaffInfo staffInfo = null;
        ArrayList<StaffInfo> staffInfos = new ArrayList<StaffInfo>();
        ResultSet rs = null;
        try {
            rs = this.executeQuery(sql, param);
            while (rs.next()) {
                staffInfo = new StaffInfo();
                staffInfo.setId(rs.getInt("id"));
                staffInfo.setPosition(rs.getString("position"));
                staffInfo.setName(rs.getString("name"));
                staffInfo.setRemark(rs.getString("remark"));
                staffInfos.add(staffInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return staffInfos;
    }

    @Override
    public StaffInfo findById(int id) {
        String sql = "SELECT * FROM staffinfo WHERE id=?";
        Object[] param = {id};
        StaffInfo staffInfo = null;
        ResultSet rs = null;
        try {
            rs = this.executeQuery(sql, param);
            if (rs.next()) {
                staffInfo = new StaffInfo();
                staffInfo.setName(rs.getString("name"));
                staffInfo.setId(rs.getInt("id"));
                staffInfo.setPosition(rs.getString("position"));
                staffInfo.setRemark(rs.getString("remark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return staffInfo;
    }

    @Override
    public int add(StaffInfo staffInfo) {
        String sql = "INSERT INTO staffinfo(name,position,remark) VALUES (?,?,?)";
        Object[] param = {staffInfo.getName(), staffInfo.getPosition(), staffInfo.getRemark()};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int del(int id) {
        String sql = "DELETE FROM staffinfo WHERE id = ?";
        Object[] param = {id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public ArrayList<StaffInfo> selectAll() {
        String sql = "SELECT * FROM staffinfo";
        ArrayList<StaffInfo> staffInfos = new ArrayList<StaffInfo>();
        ResultSet rs = this.executeQuery(sql);
        StaffInfo staffInfo = null;
        try {
            while (rs.next()) {
                staffInfo = new StaffInfo();
                staffInfo.setId(rs.getInt("id"));
                staffInfo.setName(rs.getString("name"));
                staffInfo.setPosition(rs.getString("position"));
                staffInfo.setRemark(rs.getString("remark"));
                staffInfos.add(staffInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return staffInfos;
    }
}
