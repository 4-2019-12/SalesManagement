package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Costume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CostumeMapper {
    @Select("select * from costume")
    public List<Costume> findAll();


    int insert(Costume costumeInfo);
}
