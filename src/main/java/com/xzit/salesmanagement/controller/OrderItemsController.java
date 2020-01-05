package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.entity.OrderItems;
import com.xzit.salesmanagement.entity.OrderItemsResult;
import com.xzit.salesmanagement.entity.Orders;
import com.xzit.salesmanagement.service.CostumeService;
import com.xzit.salesmanagement.service.DiscountService;
import com.xzit.salesmanagement.service.OrderItemService;
import com.xzit.salesmanagement.service.OrdersService;
import com.xzit.salesmanagement.util.CourseDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orderItems")
public class OrderItemsController {

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    CostumeService costumeService;

    @Autowired
    OrdersService ordersService;
    @Autowired
    DiscountService discountService;

    /**
     * 获取单个订单详情
     * @param page
     * @param rows
     * @param states
     * @return
     */
    @RequestMapping("/detail")
    @ResponseBody
    public CourseDatagrid<OrderItemsResult> orderlist(
            @RequestParam(value = "page",defaultValue = "1",required = false) int page,
            @RequestParam(value = "limit",defaultValue = "10",required = false) int rows,
            String states){
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        String orderId=(String) session.getAttribute("orderId");
        List<OrderItems> ordersList = orderItemService.findAllByOrderId(orderId);
        List<OrderItemsResult> ordersList1 = new ArrayList<>();
        for (int i=page*rows-rows;i<page*rows&&i<ordersList.size();i++){
            int oid = ordersList.get(i).getId();
            String ooid = ordersList.get(i).getOrderId();
            int ocid = ordersList.get(i).getCostumeId();
            int oq = ordersList.get(i).getQuantity();
            String ocn = costumeService.getCostume(ocid).getName();
            OrderItemsResult orderItemsResult = new OrderItemsResult(oid,ooid,ocid,oq,ocn);
            ordersList1.add(orderItemsResult);
        }
        CourseDatagrid<OrderItemsResult> courseDatagrid = new CourseDatagrid<OrderItemsResult>();
        courseDatagrid.setCode(0);
        courseDatagrid.setCount(ordersList.size());
        courseDatagrid.setData(ordersList1);
        courseDatagrid.setMsg("订单详情信息查询结果");
        return courseDatagrid;
    }

    /**
     * 订单详情删除订单项
     * @param data
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String del(@RequestBody JSONObject data){
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


    /**
     *
     * 订单详情改变商品数量，更新数据库
     * @param data
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String update(@RequestBody JSONObject data){
        String json = data.toJSONString();
        int id = Integer.valueOf(JSONObject.parseObject(json).getString("id"));
        int costumeId = Integer.valueOf(JSONObject.parseObject(json).getString("costumeId"));
        int quantity = Integer.valueOf(JSONObject.parseObject(json).getString("quantity"));
        OrderItems orderItems = orderItemService.findById(id);
        int change =quantity - orderItems.getQuantity();
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


    //销售提交订单，等待审核
    @RequestMapping(value = "/submit",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String submit(@RequestBody JSONObject jsonParam){
        String json = jsonParam.toJSONString();
        int consigneeId = Integer.parseInt(JSONObject.parseObject(json).getString("consigneeId"));
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        String orderId=(String) session.getAttribute("orderId");
        List<OrderItems> orderItems = orderItemService.findAllByOrderId(orderId);
        double total = 0;
        for (OrderItems o:orderItems){
            double discount = discountService.getDiscount(costumeService.getCostume(o.getCostumeId()).getDiscountId()).getDiscount();
            total +=costumeService.getCostume(o.getCostumeId()).getPrice()*discount*o.getQuantity();
            o.setDiscount(discount);
            orderItemService.update(o);
        }
        Orders orders =ordersService.getOrdersById(orderId);
        orders.setState("noexamine");
        orders.setTotal(total);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");//设置日期格式
        String date =df.format(new Date());// new Date()为获取当前系统时间
        orders.setOrderTime(date);
        orders.setConsigneeId(consigneeId);
        ordersService.update(orders);
        return "success";
    }

}
