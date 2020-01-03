package com.xzit.salesmanagement.entity;

import java.util.List;

public class Roles {
    private int id;
    private String name;
    private List<Jurisdiction> jurisdictions;
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

    @Override
    public String toString() {
        return "Roles{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public List<Jurisdiction> getJurisdictions() {
        return jurisdictions;
    }

    public void setJurisdictions(List<Jurisdiction> jurisdictions) {
        this.jurisdictions = jurisdictions;
    }
}
