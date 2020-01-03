package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.entity.Orders;
import com.xzit.salesmanagement.entity.Users;
import com.xzit.salesmanagement.service.CostumeService;
import com.xzit.salesmanagement.service.OrderItemService;
import com.xzit.salesmanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/car")
public class OrdersController {

    @Autowired
    private CostumeService costumeService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/add/{cid}")
    public String add(@PathVariable("cid") String id, Model model){
        System.out.println(id);
        Costume costume =costumeService.getCostume(Integer.valueOf(id));
        model.addAttribute("costume",costume);
        return "car/car_add";
    }

    @RequestMapping(value = "/ajaxValid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String submit(@RequestBody JSONObject jsonParam
    ) throws Exception {
        int info;
        String json = jsonParam.toJSONString();
        int id = Integer.parseInt(JSONObject.parseObject(json).getString("id"));
        int number = Integer.parseInt(JSONObject.parseObject(json).getString("number"));
        Orders orders = ordersService.getOrdersByState();
        String date = "";
        if(orders==null){
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            date =df.format(new Date());// new Date()为获取当前系统时间
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session=request.getSession();
            Users user=(Users) session.getAttribute("user");
            System.out.println(user);
            ordersService.createOrders(date,user.getId());
        }
        date = orders.getId();
        orderItemService.addItem(date,id,number);
        Costume costume =costumeService.getCostume(id);
        costume.setStock(costume.getStock()-number);
        costumeService.updateCostume(costume);
        System.out.println(orders);
        return "costume/viewProducts";
    }
}
