package com.xzit.salesmanagement.service.impl;

import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.mapper.CostumeMapper;
import com.xzit.salesmanagement.service.CostumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumeServiceImpl implements CostumeService {

    @Autowired
    private CostumeMapper costumeMapper;

    @Override
    public List<Costume> listCostumes() {
        return costumeMapper.findAll();
    }
}
