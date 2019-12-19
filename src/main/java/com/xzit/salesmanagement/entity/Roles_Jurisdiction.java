package com.xzit.salesmanagement.entity;

public class Roles_Jurisdiction {
    private int id;
    private int roleId;
    private int jurisdiction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public String toString() {
        return "Roles_Jurisdiction{" + "id=" + id + ", roleId=" + roleId + ", jurisdiction=" + jurisdiction + '}';
    }
}
