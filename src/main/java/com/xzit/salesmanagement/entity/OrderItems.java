package com.xzit.salesmanagement.entity;

public class OrderItems {
    int id;
    String orderId;
    int costumeId;
    int quantity;
    Costume costume;

    public Costume getCostume() {
        return costume;
    }

    public void setCostume(Costume costume) {
        this.costume = costume;
    }

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

    public int getCoustumeId() {
        return costumeId;
    }

    public void setCoustumeId(int coustumeId) {
        this.costumeId = coustumeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" + "id=" + id + ", orderId='" + orderId + '\'' + ", coustumeId='" + costumeId + '\'' + ", quantity=" + quantity + '}';
    }
}
