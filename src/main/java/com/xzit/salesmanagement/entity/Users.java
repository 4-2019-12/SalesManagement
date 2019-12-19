package com.xzit.salesmanagement.entity;

import java.util.List;

public class Users {
    private int id;
    private String username;
    private String password;
    private String name;
    private String mobile;
    private int purchaseId;
    private int roleId;

    public List<Jurisdiction> getJurisdictions() {
        return jurisdictions;
    }

    public void setJurisdictions(List<Jurisdiction> jurisdictions) {
        this.jurisdictions = jurisdictions;
    }

    private List<Jurisdiction> jurisdictions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getPuchaseId() {
        return purchaseId;
    }

    public void setPuchaseId(int puchaseId) {
        this.purchaseId = puchaseId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", mobile='" + mobile + '\'' + ", purchaseId='" + purchaseId + '\'' + ", roleId='" + roleId + '\'' + '}';
    }
}
