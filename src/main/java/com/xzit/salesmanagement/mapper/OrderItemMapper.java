package com.xzit.salesmanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper {

    @Insert("insert into orderitems (orderId,costumeId,quantity) values (#{orderId},#{costumeId},#{quantity})")
    public int insert(String orderId, int costumeId, int quantity);
}
