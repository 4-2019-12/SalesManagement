package com.xzit.salesmanagement.entity;

public class Discount {
    int id;
    String name;
    Double discount;

    @Override
    public String toString() {
        return "Discount{" + "id=" + id + ", name='" + name + '\'' + ", discount=" + discount + '}';
    }

    public Discount(String name, Double discount) {
        this.name = name;
        this.discount = discount;
    }

    public Discount() {
    }

    public Discount(int id, String name, Double discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
