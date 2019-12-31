package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.Costume;

import java.util.List;

public interface CostumeService {
    public List<Costume> listCostumes();

    int addCostume(Costume costumeInfo);
}
