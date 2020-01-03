package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface OrdersMapper {

    @Select("select * from orders where state = 'nosubmit'")
    Orders getOrdersBySate();

    @Insert("insert into orders (id,state,userId) values (#{id},'nosubmit',#{userId})")
    void createOrder(String id, int userId);

    @Select("select * from orders")
    List<Orders> findAll();
}
