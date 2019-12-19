package com.xzit.salesmanagement.entity;

import java.util.Date;

public class Orders {
    String id;
    Date orderTime;
    Double total;
    String state;
    String consigneeId;
    Date confirmTime;
    String userId;

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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
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

    public String getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(String consigneeId) {
        this.consigneeId = consigneeId;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
