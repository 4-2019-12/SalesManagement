package com.xzit.salesmanagement.service.impl;


import com.xzit.salesmanagement.entity.Jurisdiction;
import com.xzit.salesmanagement.entity.Roles_Jurisdiction;
import com.xzit.salesmanagement.mapper.JurisdictionMapper;
import com.xzit.salesmanagement.service.JurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurisdictionServiceImpl implements JurisdictionService {

    @Autowired
    private JurisdictionMapper jurisdictionMapper;

    @Override
    public List<Roles_Jurisdiction> getRoles_Jurisdiction() {
        return  jurisdictionMapper.getRoles_Jurisdiction();
    }

    @Override
    public Jurisdiction getJurisdictionById(int id){
        return  jurisdictionMapper.getJurisdictionById(id);
    }

    @Override
    public List<Jurisdiction> getJurisdictions() {
        return jurisdictionMapper.getJurisdiction();
    }
}
