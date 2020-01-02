package com.xzit.salesmanagement.entity;

public class Costume {
    private int id;
    private Double price;
    private String name;
    private String picture;
    private Double cost;
    private String describes;
    private int categoryId;
    private int stock;
    private String warehouseId;
    private int discountId;
    private Discount discount;
    private Category category;

    public Costume() { }

    public Costume(Double price, String name, String picture, Double cost, String describes, int categoryId, int stock, int discountId) {
        this.price = price;
        this.name = name;
        this.picture = picture;
        this.cost = cost;
        this.describes = describes;
        this.categoryId = categoryId;
        this.stock = stock;
        this.discountId = discountId;
    }


    public Costume(int id,Double price, String name, String picture, Double cost, String describes, int categoryId, int stock, int discountId) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.picture = picture;
        this.cost = cost;
        this.describes = describes;
        this.categoryId = categoryId;
        this.stock = stock;
        this.discountId = discountId;
    }
    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


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
        return describes;
    }

    public void setDescribe(String describes) {
        this.describes = describes;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
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
        return "Costume{" + "id=" + id + ", price=" + price + ", name='" + name + '\'' + ", picture='" + picture + '\'' + ", cost=" + cost + ", describes='" + describes + '\'' + ", categoryId=" + categoryId + ", stock=" + stock + ", warehouseId='" + warehouseId + '\'' + ", discountId=" + discountId + '}';
    }
}
