package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.*;
import com.xzit.salesmanagement.service.ConsigneeService;
import com.xzit.salesmanagement.util.CourseDatagrid;
import com.xzit.salesmanagement.service.CostumeService;
import com.xzit.salesmanagement.service.OrderItemService;
import com.xzit.salesmanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
@RequestMapping("/car")
public class OrdersController {

    @Autowired
    private CostumeService costumeService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ConsigneeService consigneeService;

    @RequestMapping("/add/{cid}")
    public String add(@PathVariable("cid") String id, Model model){
        Costume costume =costumeService.getCostume(Integer.valueOf(id));
        model.addAttribute("costume",costume);
        return "car/car_add";
    }

    //为订单添加商品 若无订单信息，根据时间和用户创建订单
    @Transactional
    @RequestMapping(value = "/ajaxValid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String submit(@RequestBody JSONObject jsonParam
    ) throws Exception {
        int info;
        String json = jsonParam.toJSONString();
        int id = Integer.parseInt(JSONObject.parseObject(json).getString("id"));
        int number = Integer.parseInt(JSONObject.parseObject(json).getString("number"));
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        Users user=(Users) session.getAttribute("user");
        Orders orders = ordersService.getOrdersByState(user.getId());
        System.out.println(orders);
        String date = "";
        if(orders==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            date =df.format(new Date())+user.getId();// new Date()为获取当前系统时间
            ordersService.createOrders(date,user.getId());
            orders = ordersService.getOrdersByState(user.getId());
        }
        date = orders.getId();
        OrderItems orderItems = orderItemService.findAllByOrderIdAndCostumeId(date,id);
        if(!(orderItems==null)){
            orderItems.setQuantity(orderItems.getQuantity()+number);
            orderItemService.update(orderItems);
        }else {
            orderItemService.addItem(date, id, number);
        }
        Costume costume =costumeService.getCostume(id);
        costume.setStock(costume.getStock()-number);
        costumeService.updateCostume(costume);
//        System.out.println(orders);
        return "costume/viewProducts";
    }


    //按条件分页查询课程信息
    @RequestMapping("/jwclist")
    @ResponseBody
    public CourseDatagrid<Orders> orderlist(
            @RequestParam(value = "page",defaultValue = "1",required = false) int page,
            @RequestParam(value = "limit",defaultValue = "10",required = false) int rows,
            String states){
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        Users user=(Users) session.getAttribute("user");
        List<Orders> ordersList = ordersService.findAllByUserId(user.getId());
        List<Orders> ordersList1 = new ArrayList<>();
        for (int i=page*rows-rows;i<page*rows&&i<ordersList.size();i++){
            ordersList1.add(ordersList.get(i));
        }
        CourseDatagrid<Orders> courseDatagrid = new CourseDatagrid<Orders>();
//        PageInfo<Orders> courseinfos = ordersService.jwcCourseinfoSelect(state, page, rows);
        courseDatagrid.setCode(0);
        courseDatagrid.setCount(ordersList.size());
        courseDatagrid.setData(ordersList1);
        courseDatagrid.setMsg("订单信息查询结果");
        return courseDatagrid;
    }

    @RequestMapping("/orderList")
    public String inOrder(){
        return "orders/orderlist";
    }


    @RequestMapping("/details/{id}")
    public String details(@PathVariable("id") String id, Model model,HttpSession session){
        Orders orders = ordersService.getOrdersById(id);
        session.setAttribute("orderId",id);
        model.addAttribute("order",orders);
        Users user =(Users) session.getAttribute("user");
        List<Consignee> list = consigneeService.listConsignee(user.getId());
        model.addAttribute("consignee",list);
        return "orders/orderDetails";
    }



}
