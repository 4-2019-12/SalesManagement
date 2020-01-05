package com.xzit.salesmanagement.entity;

public class Consignee {
    private int id;
    private int userId;
    private String mobile;
    private String address;
    private String name;
    private int role;

    public Consignee() {
    }

    public Consignee(int id, int userId, String mobile, String address, String name, int role) {
        this.id = id;
        this.userId = userId;
        this.mobile = mobile;
        this.address = address;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Consignee{" + "id=" + id + ", userId=" + userId + ", mobile='" + mobile + '\'' + ", address='" + address + '\'' + ", name='" + name + '\'' + ", role=" + role + '}';
    }
}
