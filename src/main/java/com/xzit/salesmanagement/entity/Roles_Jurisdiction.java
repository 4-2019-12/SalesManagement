package com.xzit.salesmanagement.entity;

public class Roles_Jurisdiction {
    private int id;
    private int roleId;
    private int jurisdiction;
    private Roles roles;
    private Jurisdiction jurisdictions;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Jurisdiction getJurisdictions() {
        return jurisdictions;
    }

    public void setJurisdictions(Jurisdiction jurisdictions) {
        this.jurisdictions = jurisdictions;
    }


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
        return "Roles_Jurisdiction{" + "id=" + id + ", roleId=" + roleId + ", jurisdiction=" + jurisdiction + ", roles=" + roles + ", jurisdictions=" + jurisdictions + '}';
    }
}
