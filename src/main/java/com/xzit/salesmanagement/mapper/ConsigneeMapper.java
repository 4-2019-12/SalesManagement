package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Consignee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ConsigneeMapper {

    @Select("select * from consignee where userId = #{userId}")
    List<Consignee> list(int userId);

    @Select("select * from consignee where id = #{id}")
    Consignee findById(int id);

    @Update("update consignee set name = #{name},mobile = #{mobile},role=#{role},address=#{address} where id = #{id}")
    void update(Consignee consignee);

    @Insert("insert into consignee (userId,name,mobile,address,role) values (#{userId},#{name},#{mobile},#{address},#{role})")
    void add(Consignee consignee);
}
