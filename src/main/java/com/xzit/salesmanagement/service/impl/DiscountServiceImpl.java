package com.xzit.salesmanagement.service.impl;

import com.xzit.salesmanagement.entity.Discount;
import com.xzit.salesmanagement.mapper.DiscountMapper;
import com.xzit.salesmanagement.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountMapper discountMapper;

    @Override
    public Discount getDiscount(int id) {
        return discountMapper.findDiscount(id);
    }

    @Override
    public List<Discount> listDiscount() {
        return discountMapper.findAllDiscount();
    }
}
