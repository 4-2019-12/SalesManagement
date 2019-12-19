package com.xzit.salesmanagement.entity;

public class OrderItems {
    int id;
    String orderId;
    String coustumeId;
    int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCoustumeId() {
        return coustumeId;
    }

    public void setCoustumeId(String coustumeId) {
        this.coustumeId = coustumeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" + "id=" + id + ", orderId='" + orderId + '\'' + ", coustumeId='" + coustumeId + '\'' + ", quantity=" + quantity + '}';
    }
}
