package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Discount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiscountMapper {

    @Select("select * from discount where id = #{id}")
    public Discount findDiscount(int id);

    @Select("select * from discount")
    public List<Discount> findAllDiscount();
}
