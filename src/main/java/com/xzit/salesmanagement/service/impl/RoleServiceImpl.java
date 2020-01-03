package com.xzit.salesmanagement.service.impl;

import com.xzit.salesmanagement.entity.Roles;
import com.xzit.salesmanagement.mapper.RoleMapper;
import com.xzit.salesmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Roles getRoleById(int id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public List<Roles> getRoles() {
        return roleMapper.getRoles();
    }
}
