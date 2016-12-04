package com.fams.dao.impl;

import com.fams.dao.BaseDao;
import com.fams.dao.NoteDao;
import com.fams.entity.Note;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by quyuan on 16/7/12.
 */
public class NoteDaoImpl extends BaseDao implements NoteDao {
    @Override
    public int insertBorrowInfo(int assetid, String staffName, String name, String usefor, String remark) {
        String sql = "INSERT INTO note (assetid,staffName,borrowDate,borrowManagerName,usefor,remark) VALUES (?,?,NOW(),?,?,?)";
        Object[] param = {assetid, staffName, name, usefor,remark};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int updateReturnInfo(String name,int assetid) {
        String sql = "UPDATE note SET returnDate=NOW(),returnManagerName = ? WHERE assetid=?";
        Object[] param = {name,assetid};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }


    @Override
    public ArrayList<Note> selectAll() {
        String sql = "SELECT * FROM note";
        ArrayList<Note> notes = new ArrayList<Note>();
        ResultSet rs = this.executeQuery(sql);
        Note note = null;
        try {
            while (rs.next()) {
                note = new Note();
                note.setId(rs.getInt("id"));
                note.setBorrowDate(rs.getDate("borrowDate"));
                note.setBorrowManagerName(rs.getString("borrowManagerName"));
                note.setAssetid(rs.getInt("assetid"));
                note.setStaffName(rs.getString("staffName"));
                note.setUsefor(rs.getString("usefor"));
                note.setReturnDate(rs.getDate("returnDate"));
                note.setReturnManagerName(rs.getString("returnManagerName"));
                note.setRemark(rs.getString("remark"));
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return notes;
    }

}
