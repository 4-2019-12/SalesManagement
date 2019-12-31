package com.xzit.salesmanagement.controller;


import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @RequestMapping(value = "/getDiscount",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void getDiscount(@RequestBody JSONObject jsonParam){
        String json = jsonParam.toJSONString();
        int id =Integer.parseInt(JSONObject.parseObject(json).getString("loginName"));
        discountService.getDiscount(id);
    }
}
