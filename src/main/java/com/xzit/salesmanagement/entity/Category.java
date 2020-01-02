package com.xzit.salesmanagement.entity;

public class Category {

    private int id;
    private String name;
    private String describes;

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

    public String getDescribe() {
        return describes;
    }

    public void setDescribe(String describes) {
        this.describes = describes;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name='" + name + '\'' + ", describe='" + describes + '\'' + '}';
    }
}
