package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.Discount;

import java.util.List;

public interface DiscountService {
    public Discount getDiscount(int id);
    public List<Discount> listDiscount();
}
