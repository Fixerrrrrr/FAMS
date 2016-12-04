package com.fams.entity;

/**
 * Created by quyuan on 16/7/12.
 */
public class Manager {
    /**
     * 管理员编号
     */
    private int id;
    /**
     * 管理员用户名
     */
    private String name;
    /**
     * 管理员密码
     */
    private String password;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
