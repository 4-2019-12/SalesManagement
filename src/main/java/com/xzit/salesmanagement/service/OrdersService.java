package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.Orders;

public interface OrdersService {

    public Orders getOrdersByState();

    void createOrders(String date,int userId);
}
