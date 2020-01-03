package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Jurisdiction;
import com.xzit.salesmanagement.entity.Roles_Jurisdiction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JurisdictionMapper {

    @Select("select * from jurisdiction where id = #{id}")
    Jurisdiction getJurisdictionById(int id);

    @Select("select * from roles_jurisdiction")
    List<Roles_Jurisdiction> getRoles_Jurisdiction();

    @Select("select * from jurisdiction")
    List<Jurisdiction> getJurisdiction();
}
