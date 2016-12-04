package com.fams.entity;

import java.sql.Date;

/**
 * Created by quyuan on 16/7/12.
 */
public class Note {
    /**
     * 资产记录编号
     */
    private int id;
    /**
     * 资产编号
     */
    private int assetid;
    /**
     * 借出人员姓名
     */
    private String staffName;
    /**
     * 借出日期
     */
    private Date borrowDate;
    /**
     * 借出时管理员名字
     */
    private String borrowManagerName;
    /**
     * 借出用途
     */
    private String usefor;
    /**
     * 归还日期
     */
    private Date returnDate;
    /**
     * 归还时管理员名字
     */
    private String returnManagerName;
    /**
     * 备注
     */
    private String remark;

    public int getAssetid() {
        return assetid;
    }

    public void setAssetid(int assetid) {
        this.assetid = assetid;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBorrowManagerName() {
        return borrowManagerName;
    }

    public void setBorrowManagerName(String borrowManagerName) {
        this.borrowManagerName = borrowManagerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnManagerName() {
        return returnManagerName;
    }

    public void setReturnManagerName(String returnManagerName) {
        this.returnManagerName = returnManagerName;
    }

    public String getUsefor() {
        return usefor;
    }

    public void setUsefor(String usefor) {
        this.usefor = usefor;
    }
}
