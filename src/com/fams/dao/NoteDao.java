package com.fams.dao;

import com.fams.entity.Note;

import java.util.ArrayList;

/**
 * Created by quyuan on 16/7/12.
 */
public interface NoteDao {
    /**
     * 资产分配时插入一条新的借出信息
     *
     * @param assetid   资产编号
     * @param staffName   员工姓名
     * @param name      管理员名字
     * @return 影响的行数
     */
    int insertBorrowInfo(int assetid,  String staffName, String name, String usefor, String remark);

    /**
     * 资产归还时更新相应的信息
     *
     * @param name 管理员名字
     * @return 影响的行数
     */
    int updateReturnInfo(String name,int assetid);

    /**
     * 选中所有信息
     * @return 所有信息
     */
    ArrayList<Note> selectAll();

}
