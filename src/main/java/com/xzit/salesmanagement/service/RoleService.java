package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.Roles;

import java.util.List;


public interface RoleService {
    public Roles getRoleById(int id);

    List<Roles> getRoles();
}
