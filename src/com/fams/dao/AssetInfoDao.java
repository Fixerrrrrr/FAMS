package com.fams.dao;

import com.fams.entity.AssetInfo;

import java.util.ArrayList;

/**
 * Created by quyuan on 16/7/12.
 */
public interface AssetInfoDao {
    /**
     * 增加资产信息
     *
     * @param assetInfo
     * @return 修改的行数
     */
    int add(AssetInfo assetInfo);

    /**
     * 删除资产信息
     *
     * @param id
     * @return 修改的行数
     */
    int del(int id);

    /**
     * 修改资产基础信息
     *
     * @param id        要修改的资产的编号
     * @param assetInfo 修改后的信息
     * @return 修改的行数
     */
    int updateBaseInfo(AssetInfo assetInfo, int id);

    /**
     * 修改资产状态
     *
     * @param status
     * @return 修改的行数
     */
    int updateStatus(String status, int id);

    /**
     * 修改资产借出信息
     *
     * @param id
     * @return 修改的行数
     */
    int updateUser(int userid, int id);

    /**
     * 归还时的修改
     *
     * @param id
     * @return
     */
    int updateUserToNull(int id);

    /**
     * 修改备注
     *
     * @param remark
     * @return 修改的行数
     */
    int updateRemark(String remark, int id);


    /**
     * 按编号查找资产信息
     *
     * @param id
     * @return 查找到的资产信息
     */
    AssetInfo findById(int id);


    /**
     * 选中所有资产信息
     *
     * @return 所有资产信息
     */
    ArrayList<AssetInfo> selectAll();

    /**
     * 根据资产名判断资产是否已分配
     *
     * @param id
     * @return
     */
    boolean isBorrowed(int id);

}
