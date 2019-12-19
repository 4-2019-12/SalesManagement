package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.Jurisdiction;
import com.xzit.salesmanagement.entity.Users;

import java.util.List;


public interface LoginService {
    public Users findByUsername(String username);
    public List<Jurisdiction> getJurisdiction(int role);
}
