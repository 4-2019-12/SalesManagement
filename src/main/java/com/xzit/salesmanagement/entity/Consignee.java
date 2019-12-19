package com.xzit.salesmanagement.entity;

import java.util.Date;

public class Consignee {
    int id;
    String content;
    String orderId;
    Date time;

    @Override
    public String toString() {
        return "Consignee{" + "id=" + id + ", content='" + content + '\'' + ", orderId='" + orderId + '\'' + ", time=" + time + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
