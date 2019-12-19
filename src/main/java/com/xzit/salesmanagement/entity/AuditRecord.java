package com.xzit.salesmanagement.entity;

import java.util.Date;

public class AuditRecord {
    int id;
    String suggestion;
    String orderId;
    Date time;
    String userId;

    @Override
    public String toString() {
        return "AuditRecord{" + "id=" + id + ", suggestion='" + suggestion + '\'' + ", orderId='" + orderId + '\'' + ", time=" + time + ", userId='" + userId + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
