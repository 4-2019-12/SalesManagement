package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.Consignee;

import java.util.List;

public interface ConsigneeService {
    List<Consignee> listConsignee(int userId);

    Consignee findById(int id);

    void update(Consignee consignee);

    void add(Consignee consignee);
}
