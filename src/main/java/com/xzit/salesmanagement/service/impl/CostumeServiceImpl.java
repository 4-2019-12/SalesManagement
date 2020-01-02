package com.xzit.salesmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.mapper.CostumeMapper;
import com.xzit.salesmanagement.service.CostumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumeServiceImpl implements CostumeService {

    @Autowired
    private CostumeMapper costumeMapper;

    @Override
    public List<Costume> listCostumes() {
        return costumeMapper.findAll();
    }

    @Override
    public int addCostume(Costume costumeInfo) {
        return costumeMapper.insert(costumeInfo);
    }

    @Override
    public Costume getCostume(Integer id) {
        return costumeMapper.selectById(id);
    }

    @Override
    public int updateCostume(Costume costume) {
        return costumeMapper.updateById(costume);
    }

    @Override
    public List<Costume> findAllByPageF(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Costume> lists = costumeMapper.findAll();
        return lists;
    }

    @Override
    public PageInfo<Costume> findAllByPageS(int pageNum, int pageSize) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Costume> lists = costumeMapper.findAll();
        PageInfo<Costume> pageInfo = new PageInfo<Costume>(lists);
        return pageInfo;
    }

    @Override
    public int delCostumeById(int costumeId) {
        return costumeMapper.delCostumeById(costumeId);
    }
}
