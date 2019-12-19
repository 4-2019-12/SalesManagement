package com.xzit.salesmanagement.entity;

public class Purchase {
    int id;
    String userId;
    Double total;

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", userId='" + userId + '\'' + ", total=" + total + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
