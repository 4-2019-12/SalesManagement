package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Discount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DiscountMapper {

    @Select("select * from discount where id = #{id}")
    public Discount findDiscount(int id);

    @Select("select * from discount")
    public List<Discount> findAllDiscount();


    @Insert("Insert into discount (name,discount) values (#{name},#{discount})")
    int add(Discount discount);

    @Update("update discount set name = #{name} , discount = #{discount} where id = #{id}")
    int update(Discount discount);
}
