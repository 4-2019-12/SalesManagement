package com.xzit.salesmanagement.mapper;

import com.xzit.salesmanagement.entity.OrderItems;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderItemMapper {

    @Insert("insert into orderitems (orderId,costumeId,quantity) values (#{orderId},#{costumeId},#{quantity})")
    public int insert(String orderId, int costumeId, int quantity);

    @Select("select * from orderitems where orderId = #{orderId}")
    List<OrderItems> findByOrderId(String orderId);

    @Delete("delete from orderitems where id = #{id}")
    void del(int id);

    @Select("select * from orderitems where orderId = #{orderId} and costumeId = #{costumeId}")
    OrderItems findAllByOrderIdAndCostumeId(String orderId, int costumeId);

    @Update("update orderitems set quantity = #{quantity}, discount = #{discount} where id = #{id}")
    void update(OrderItems orderItems);

    @Select("select * from orderitems where id = #{id}")
    OrderItems findById(int id);
}
