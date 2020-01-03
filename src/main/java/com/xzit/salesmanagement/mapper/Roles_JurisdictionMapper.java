package com.xzit.salesmanagement.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Roles_JurisdictionMapper {

    @Insert("insert into roles_jurisdiction (roleId,jurisdictionId)values(#{roleId},#{jurisdictionId})")
    public int insert(int roleId,int jurisdictionId);

    @Delete("delete from roles_jurisdiction where roleId=#{roleId} and jurisdictionId=#{jurisdictionId}")
    public int delete(int roleId,int jurisdictionId);
}
