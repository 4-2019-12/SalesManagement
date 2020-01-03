package com.xzit.salesmanagement.service;

import com.github.pagehelper.PageInfo;
import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.entity.OrderItems;
import com.xzit.salesmanagement.entity.Orders;

import java.util.List;

public interface OrdersService {

    public Orders getOrdersByState();

    void createOrders(String date,int userId);

    List<Orders> findAll();

    PageInfo<Orders> jwcCourseinfoSelect(String state,
                                         Integer pageNo, Integer pageSize);
}
