package com.xzit.salesmanagement.controller;


import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Discount;
import com.xzit.salesmanagement.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 跳转到显示所有折扣的界面
     * @return
     */
    @RequestMapping(value = "setdiscounts",produces = "application/json; charset=utf-8")
    public String jump(Model model)
    {
        List<Discount> discounts = discountService.listDiscount();
        model.addAttribute("discounts",discounts);
        return "discount/setdiscounts";
    }

    @RequestMapping("/addDiscount/{id}")
    public String toAddpage(@PathVariable("id") Integer id, Model model) {

        System.out.println(id);
        Discount discount=null;
        if(!id.equals("0")){
            discount = discountService.getDiscount(id);
        }
        model.addAttribute("discount",discount);
        model.addAttribute("flag",id);
        return "discount/editDiscount";
    }

    @RequestMapping(value = "/discount/ajaxValid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addCostume(@RequestBody JSONObject jsonParam
    ) throws Exception {
        int info;
        String json = jsonParam.toJSONString();
        int id = Integer.parseInt(JSONObject.parseObject(json).getString("id"));
        Double discount =Double.valueOf(JSONObject.parseObject(json).getString("discount"));
        String name =JSONObject.parseObject(json).getString("name");
        if(id==0){
            Discount discount1 =new Discount(name,discount);
            info = discountService.addDiscount(discount1);
        }else {
            Discount discount1 =new Discount(id,name,discount);
            info = discountService.updateDiscount(discount1);
        }
        System.out.println(info);
        // 页面转发
        return "discount/setdiscounts";
    }

}
