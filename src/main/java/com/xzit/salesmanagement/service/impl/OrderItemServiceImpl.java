package com.xzit.salesmanagement.service.impl;

import com.xzit.salesmanagement.entity.OrderItems;
import com.xzit.salesmanagement.mapper.OrderItemMapper;
import com.xzit.salesmanagement.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;


    @Override
    public void addItem(String orderId, int costumeId, int quantity) {
        orderItemMapper.insert(orderId,costumeId,quantity);
    }

    @Override
    public List<OrderItems> findAllByOrderId(String orderId) {
        return orderItemMapper.findByOrderId(orderId);
    }

    @Override
    public void del(int id) {
        orderItemMapper.del(id);
    }

    @Override
    public OrderItems findAllByOrderIdAndCostumeId(String date, int id) {
        return orderItemMapper.findAllByOrderIdAndCostumeId(date,id);
    }

    @Override
    public void update(OrderItems orderItems) {
        orderItemMapper.update(orderItems);
    }

    @Override
    public OrderItems findById(int id) {
        return orderItemMapper.findById(id);
    }
}
