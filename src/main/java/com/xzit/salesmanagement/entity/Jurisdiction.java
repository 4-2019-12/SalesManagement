package com.xzit.salesmanagement.entity;

public class Jurisdiction {
    private int id;
    private String function;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Jurisdiction{" + "id=" + id + ", function='" + function + '\'' + '}';
    }
}
