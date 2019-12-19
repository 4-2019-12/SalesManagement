package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Jurisdiction;
import com.xzit.salesmanagement.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users where username = #{username}")
    public Users selectByUsername(String username);

//    public int selectRole(@Param("username") String username);

    public List<Jurisdiction> getJurisdiction(@Param("role")int role);
}
