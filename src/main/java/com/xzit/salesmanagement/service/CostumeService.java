package com.xzit.salesmanagement.service;

import com.github.pagehelper.PageInfo;
import com.xzit.salesmanagement.entity.Costume;

import java.util.List;

public interface CostumeService {
    public List<Costume> listCostumes();

    int addCostume(Costume costumeInfo);

    Costume getCostume(Integer id);

    int updateCostume(Costume costume);

    List<Costume> findAllByPageF(int pageNum,int pageSize);

    PageInfo<Costume> findAllByPageS(int pageNum, int pageSize);

    int delCostumeById(int costumeId);
}
