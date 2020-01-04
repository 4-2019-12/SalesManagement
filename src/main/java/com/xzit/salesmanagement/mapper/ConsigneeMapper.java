package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Consignee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConsigneeMapper {

    @Select("select * from consignee where userId = #{userId}")
    List<Consignee> list(int userId);
}
