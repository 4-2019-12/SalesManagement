package com.xzit.salesmanagement.entity;

public class Costume {
    int id;
    Double price;
    String name;
    String picture;
    Double cost;
    String describe;
    int categoryId;
    Double stock;
    String warehouseId;
    int discountId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    @Override
    public String toString() {
        return "Costume{" + "id=" + id + ", price=" + price + ", name='" + name + '\'' + ", picture='" + picture + '\'' + ", cost=" + cost + ", describe='" + describe + '\'' + ", categoryId=" + categoryId + ", stock=" + stock + ", warehouseId='" + warehouseId + '\'' + ", discountId=" + discountId + '}';
    }
}
