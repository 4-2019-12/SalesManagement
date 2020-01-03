package com.xzit.salesmanagement.service.impl;

import com.xzit.salesmanagement.mapper.OrderItemMapper;
import com.xzit.salesmanagement.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;


    @Override
    public void addItem(String orderId, int costumeId, int quantity) {
        orderItemMapper.insert(orderId,costumeId,quantity);
    }
}
