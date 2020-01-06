package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Fund;
import com.xzit.salesmanagement.entity.Orders;
import com.xzit.salesmanagement.entity.Users;
import com.xzit.salesmanagement.service.OrdersService;
import com.xzit.salesmanagement.util.Fundutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fund")
public class FundController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("")
    public String fund(Model model, HttpSession session){
        List<Fund> funds = Fundutil.getFund(8,session,ordersService);
        model.addAttribute("funds",funds);
        return "orders/fund";
    }
    @RequestMapping(value = "/change",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String change(@RequestBody String jsonParam, HttpSession session,Model model) throws Exception{
        String json = jsonParam.substring(jsonParam.lastIndexOf("=")+1);
        System.out.println(json);
        int id = Integer.parseInt(json);
        List<Fund> funds = new ArrayList<Fund>();
        if(id==0){
            funds = Fundutil.getFund(8,session,ordersService);
        }else if(id==1){
            funds = Fundutil.getFund(6,session,ordersService);
        }else if(id==2){
            funds = Fundutil.getFund(4,session,ordersService);
        }
        model.addAttribute("funds",funds);
        return "success";
    }

    @RequestMapping(value = "/change1")
    public String change1(String symbol,HttpSession session,Model model) throws Exception{
        int id = Integer.parseInt(symbol);
        List<Fund> funds = new ArrayList<Fund>();
        if(id==0){
            funds = Fundutil.getFund(8,session,ordersService);
        }else if(id==1){
            funds = Fundutil.getFund(6,session,ordersService);
        }else if(id==2){
            funds = Fundutil.getFund(4,session,ordersService);
        }
        model.addAttribute("funds",funds);
        return "orders/fund_table";
    }
}
