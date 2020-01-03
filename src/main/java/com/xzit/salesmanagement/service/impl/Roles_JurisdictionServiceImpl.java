package com.xzit.salesmanagement.service.impl;

import com.xzit.salesmanagement.mapper.Roles_JurisdictionMapper;
import com.xzit.salesmanagement.service.Roles_JurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Roles_JurisdictionServiceImpl implements Roles_JurisdictionService {

    @Autowired
    private Roles_JurisdictionMapper roles_jurisdictionMapper;

    @Override
    public int add(int roleId, int jurisdictionId) {
        return roles_jurisdictionMapper.insert(roleId,jurisdictionId);
    }

    @Override
    public int del(int roleId, int jurisdictionId) {
        return roles_jurisdictionMapper.delete(roleId,jurisdictionId);
    }
}
