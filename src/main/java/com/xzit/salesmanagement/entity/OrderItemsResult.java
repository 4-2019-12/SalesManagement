package com.xzit.salesmanagement.entity;

public class OrderItemsResult {

        int id;
        String orderId;
        int costumeId;
        int quantity;
        String costumeName;

    public OrderItemsResult() {
    }

    public OrderItemsResult(int id, String orderId, int costumeId, int quantity,String costumeName) {
        this.id = id;
        this.orderId = orderId;
        this.costumeId = costumeId;
        this.quantity = quantity;
        this.costumeName = costumeName;
    }

    public String getCostumeName() {
            return costumeName;
        }

        public void setCostumeName(String costumeName) {
            this.costumeName = costumeName;
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

        public int getCostumeId() {
            return costumeId;
        }

        public void setCostumeId(int costumeId) {
            this.costumeId = costumeId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

    @Override
    public String toString() {
        return "OrderItemsResult{" + "id=" + id + ", orderId='" + orderId + '\'' + ", coustumeId=" + costumeId + ", quantity=" + quantity + ", costumeName='" + costumeName + '\'' + '}';
    }
}
