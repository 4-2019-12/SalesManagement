package com.xzit.salesmanagement.entity;

public class Warehouse {
    int id;
    String name;
    String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Warehouse{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + '}';
    }
}
