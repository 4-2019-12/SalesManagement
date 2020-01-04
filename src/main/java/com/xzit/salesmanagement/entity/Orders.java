package com.xzit.salesmanagement.entity;


public class Orders {
    String id;
    String orderTime;
    Double total;
    String state;
    int consigneeId;
    String confirmTime;
    int userId;

    @Override
    public String toString() {
        return "Orders{" + "id='" + id + '\'' + ", orderTime=" + orderTime + ", total=" + total + ", state='" + state + '\'' + ", consigneeId='" + consigneeId + '\'' + ", confirmTime=" + confirmTime + ", userId='" + userId + '\'' + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(int consigneeId) {
        this.consigneeId = consigneeId;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
