package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.Jurisdiction;
import com.xzit.salesmanagement.entity.Roles_Jurisdiction;

import java.util.List;

public interface JurisdictionService {
    public List<Roles_Jurisdiction> getRoles_Jurisdiction();
    public Jurisdiction getJurisdictionById(int id);

    List<Jurisdiction> getJurisdictions();

}
