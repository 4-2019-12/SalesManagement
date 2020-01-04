package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.entity.OrderItems;
import com.xzit.salesmanagement.entity.OrderItemsResult;
import com.xzit.salesmanagement.service.CostumeService;
import com.xzit.salesmanagement.service.OrderItemService;
import com.xzit.salesmanagement.util.CourseDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orderItems")
public class OrderItemsController {

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    CostumeService costumeService;

    @RequestMapping("/detail")
    @ResponseBody
    public CourseDatagrid<OrderItemsResult> orderlist(
            @RequestParam(value = "page",defaultValue = "1",required = false) int page,
            @RequestParam(value = "limit",defaultValue = "10",required = false) int rows,
            String states){
        System.out.println(states);

        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        String orderId=(String) session.getAttribute("orderId");
        List<OrderItems> ordersList = orderItemService.findAllByOrderId(orderId);
        List<OrderItemsResult> ordersList1 = new ArrayList<>();
        for (int i=page*rows-rows;i<page*rows&&i<ordersList.size();i++){
            int oid = ordersList.get(i).getId();
            String ooid = ordersList.get(i).getOrderId();
            int ocid = ordersList.get(i).getCoustumeId();
            int oq = ordersList.get(i).getQuantity();
            String ocn = costumeService.getCostume(ocid).getName();
            OrderItemsResult orderItemsResult = new OrderItemsResult(oid,ooid,ocid,oq,ocn);
            ordersList1.add(orderItemsResult);
        }
        CourseDatagrid<OrderItemsResult> courseDatagrid = new CourseDatagrid<OrderItemsResult>();
//        PageInfo<Orders> courseinfos = ordersService.jwcCourseinfoSelect(state, page, rows);
        System.out.println(ordersList1);
        courseDatagrid.setCode(0);
        courseDatagrid.setCount(ordersList.size());
        courseDatagrid.setData(ordersList1);
        courseDatagrid.setMsg("订单详情信息查询结果");
        return courseDatagrid;
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String del(@RequestBody JSONObject data){
        System.out.println(data);
        String json = data.toJSONString();
        int id = Integer.valueOf(JSONObject.parseObject(json).getString("id"));
        int costumeId = Integer.valueOf(JSONObject.parseObject(json).getString("costumeId"));
        int quantity = Integer.valueOf(JSONObject.parseObject(json).getString("quantity"));
        Costume costume = costumeService.getCostume(costumeId);
        costume.setStock(costume.getStock()+quantity);
        costumeService.updateCostume(costume);
        orderItemService.del(id);
        return "success";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String update(@RequestBody JSONObject data){
        System.out.println(data);
        String json = data.toJSONString();
        int id = Integer.valueOf(JSONObject.parseObject(json).getString("id"));
        int costumeId = Integer.valueOf(JSONObject.parseObject(json).getString("costumeId"));
        int quantity = Integer.valueOf(JSONObject.parseObject(json).getString("quantity"));
        OrderItems orderItems = orderItemService.findById(id);
        int change =quantity - orderItems.getQuantity();
        System.out.println(change);
        Costume costume = costumeService.getCostume(costumeId);
        int stock = costume.getStock();
        if(change>stock){
            return "目前库存剩余："+stock+"请输入正确的数字！";
        }
        costume.setStock(costume.getStock()-change);
        costumeService.updateCostume(costume);
        orderItems.setQuantity(quantity);
        orderItemService.update(orderItems);
        return "success";
    }
}
