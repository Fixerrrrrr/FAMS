package com.fams.dao.impl;

import com.fams.dao.BaseDao;
import com.fams.dao.ManagerDao;
import com.fams.entity.Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by quyuan on 16/7/12.
 */


public class ManagerDaoImpl extends BaseDao implements ManagerDao {


    @Override
    public Manager findManager(Manager manager) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Manager man = null;
        try {
            conn = this.getConnection();
            String sql = "SELECT * FROM manager WHERE name = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, manager.getName());
            pstmt.setString(2, manager.getPassword());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                man = new Manager();
                man.setId(rs.getInt("id"));
                man.setName(rs.getString("name"));
                man.setPassword(rs.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn,pstmt,rs);
        }
        return man;
    }

}