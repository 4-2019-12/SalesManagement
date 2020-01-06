package com.xzit.salesmanagement.service.impl;

import com.github.pagehelper.PageInfo;
import com.xzit.salesmanagement.entity.Orders;
import com.xzit.salesmanagement.mapper.OrdersMapper;
import com.xzit.salesmanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public Orders getOrdersByState(int userId) {
        return ordersMapper.getOrdersBySate(userId);
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
    public List<Orders> findAllByUserId(int userId) {
        return ordersMapper.findAllByUserId(userId);
    }

    @Override
    public List<Orders> findAllByUserIdAndState(int userId, String state) {
        return ordersMapper.findAllByUserIdAndStaet(userId,state);
    }

    @Override
    public PageInfo<Orders> jwcCourseinfoSelect(String state, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public Orders getOrdersById(String id) {
        return ordersMapper.findById(id);
    }

    @Override
    public void update(Orders orders) {
        ordersMapper.update(orders);
    }

}
