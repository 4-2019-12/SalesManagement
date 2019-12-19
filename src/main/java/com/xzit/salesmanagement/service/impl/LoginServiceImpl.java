package com.xzit.salesmanagement.service.impl;


import com.xzit.salesmanagement.entity.Jurisdiction;
import com.xzit.salesmanagement.entity.Users;
import com.xzit.salesmanagement.mapper.JurisdictionMapper;
import com.xzit.salesmanagement.mapper.UsersMapper;
import com.xzit.salesmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersMapper usersMapper;

//    @Autowired
//    private JurisdictionMapper jurisdictionMapper;

    @Override
    public Users findByUsername(String username) {
        return usersMapper.selectByUsername(username);
    }

    @Override
    public List<Jurisdiction> getJurisdiction(int role) {
        return usersMapper.getJurisdiction(role);
    }
}
