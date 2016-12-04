package com.fams.entity;

/**
 * Created by quyuan on 16/7/12.
 */
public class StaffInfo {
    /**
     * 员工编号
     */
    private int id;
    /**
     * 员工名字
     */
    private String name;
    /**
     * 员工职位
     */
    private String position;
    /**
     * 备注
     */
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
