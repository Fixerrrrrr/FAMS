package com.fams.dao;

import com.fams.entity.StaffInfo;

import java.util.ArrayList;

/**
 * Created by quyuan on 16/7/12.
 */
public interface StaffInfoDao {
    /**
     * 根据名字查找员工
     *
     * @param name
     * @return 查找到的员工
     */
    ArrayList<StaffInfo> findByName(String name);

    /**
     * 根据id查找员工
     *
     * @param id
     * @return 查找到的员工
     */
    StaffInfo findById(int id);

    /**
     * 增
     *
     * @param staffInfo 员工信息
     * @return 行数
     */
    int add(StaffInfo staffInfo);

    /**
     * 删
     *
     * @param id 人员编号
     * @return 行数
     */
    int del(int id);


    /**
     * 选中所有
     * @return
     */
    ArrayList<StaffInfo> selectAll();
}
