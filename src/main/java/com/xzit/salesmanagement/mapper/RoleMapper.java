package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from roles where id = #{id}")
    Roles getRoleById(int id);

    @Select("select * from roles")
    List<Roles> getRoles();
}
