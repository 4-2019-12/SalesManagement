package com.xzit.salesmanagement.service.impl;

import com.github.pagehelper.PageInfo;
import com.xzit.salesmanagement.entity.OrderItems;
import com.xzit.salesmanagement.entity.Orders;
import com.xzit.salesmanagement.mapper.OrdersMapper;
import com.xzit.salesmanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public Orders getOrdersByState() {
        return ordersMapper.getOrdersBySate();
    }

    @Override
    public void createOrders(String date,int userId) {
        ordersMapper.createOrder(date,userId);
    }

    @Override
    public List<Orders> findAll() {
        return ordersMapper.findAll();
    }

    @Override
    public PageInfo<Orders> jwcCourseinfoSelect(String state, Integer pageNo, Integer pageSize) {
        return null;
    }
}
