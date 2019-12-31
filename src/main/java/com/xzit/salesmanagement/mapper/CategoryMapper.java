package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
//    @Select("select * from category where id= #{id} ")
    public Category getCategory(@Param("id") int id);
//
    @Select("select * from category")
    List<Category> findAllCategory();
//
//    @Insert(" insert into category_ ( name,a) values (#{name},#{a}) ")
//    public int save(Category category);
//
//    @Delete(" delete from category_ where id= #{id} ")
//    public void delete(int id);
//
//    @Select("select * from category_ where id= #{id} ")
//    public Category get(int id);
//
//    @Update("update category_ set name=#{name},a=#{a} where id=#{id} ")
//    public int update(Category category);
 
}