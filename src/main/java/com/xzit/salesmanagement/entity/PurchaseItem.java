package com.xzit.salesmanagement.entity;

public class PurchaseItem {
    int id;
    int quantity;
    int costumeId;
    int purchaseId;

    @Override
    public String toString() {
        return "PurchaseItem{" + "id=" + id + ", quantity=" + quantity + ", costumeId=" + costumeId + ", purchaseId=" + purchaseId + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCostumeId() {
        return costumeId;
    }

    public void setCostumeId(int costumeId) {
        this.costumeId = costumeId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }
}
