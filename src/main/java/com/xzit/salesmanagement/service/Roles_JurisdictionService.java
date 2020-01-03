package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.mapper.Roles_JurisdictionMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface Roles_JurisdictionService {

    public int add(int roleId,int jurisdictionId);

    public int del(int roleId,int jurisdictionId);
}
