package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.OrderItems;

import java.util.List;

public interface OrderItemService {

    public void addItem(String orderId,int costumeId,int quantity);

    List<OrderItems> findAllByOrderId(String orderId);

    void del(int id);

    OrderItems findAllByOrderIdAndCostumeId(String date, int id);

    void update(OrderItems orderItems);

    OrderItems findById(int id);
}
