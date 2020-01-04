package com.xzit.salesmanagement.service.impl;

import com.xzit.salesmanagement.entity.Consignee;
import com.xzit.salesmanagement.mapper.ConsigneeMapper;
import com.xzit.salesmanagement.service.ConsigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsigneeServiceImpl implements ConsigneeService {

    @Autowired
    ConsigneeMapper consigneeMapper;
    @Override
    public List<Consignee> listConsignee(int userId) {
        return consigneeMapper.list(userId);
    }
}
