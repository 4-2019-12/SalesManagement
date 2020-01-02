package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Costume;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CostumeMapper {
    @Select("select * from costume")
    public List<Costume> findAll();

    @Select("select * from costume where id = #{id}")
    Costume selectById(Integer id);

    @Update("update costume set price=#{price},name=#{name},picture=#{picture},cost=#{cost},describes=#{describes},categoryId=#{categoryId},stock=#{stock},discountId=#{discountId} where id = #{id}")
    int updateById(Costume costume);

    int insert(Costume costumeInfo);

    @Delete("delete from costume where id = #{id}")
    int delCostumeById(int id);
}
