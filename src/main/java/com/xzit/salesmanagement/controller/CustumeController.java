package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Category;
import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.entity.Discount;
import com.xzit.salesmanagement.service.CategoryService;
import com.xzit.salesmanagement.service.CostumeService;
import com.xzit.salesmanagement.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustumeController {

    @Autowired
    CostumeService costumeService;

    @Autowired
    DiscountService discountService;

    @Autowired
    CategoryService categoryService;

    //跳转查看商品页面
    @RequestMapping(value = "/viewProducts")
    public String viewProducts(Model model) {
        List<Costume> costumeList;
        costumeList = costumeService.listCostumes();
        for (Costume c : costumeList) {
            c.setDiscount(discountService.getDiscount(c.getDiscountId()));
            c.setCategory(categoryService.getCategory(c.getCategoryId()));
        }
        model.addAttribute("costumeList", costumeList);
        return "costume/viewProducts";
    }

    //跳转管理商品页面
    @RequestMapping(value = "/listCostume")
    public String listCostume(Model model) {
        List<Costume> costumeList;
        costumeList = costumeService.listCostumes();
        for (Costume c : costumeList) {
            c.setDiscount(discountService.getDiscount(c.getDiscountId()));
            c.setCategory(categoryService.getCategory(c.getCategoryId()));
        }
        model.addAttribute("costumeList", costumeList);
        return "costume/listCostume";
    }

    //添加商品
    @RequestMapping(value = "/addCostume")
    public String addCostume(Model model) {
        List<Category> categoryList = categoryService.listCategory();
        List<Discount> discountList = discountService.listDiscount();
        model.addAttribute("discountList", discountList);
        model.addAttribute("categoryList", categoryList);
        return "costume/addCostume";
    }

    //跳转管理商品页面
    @RequestMapping("/editCostume/{id}")
    public String toAddpage(@PathVariable("id") Integer id, Model model) {
        System.out.println("id=" + id);
        return "costume/addCostume";
    }

    @RequestMapping(value = "/costumeInfo/ajaxValid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addCostume(@RequestBody JSONObject jsonParam, Model model// 获取校验错误信息
    ) throws Exception {
        String json = jsonParam.toJSONString();
        int category=Integer.parseInt(JSONObject.parseObject(json).getString("categoryId"));
        Double price =Double.valueOf(JSONObject.parseObject(json).getString("price"));
        int discount =Integer.parseInt(JSONObject.parseObject(json).getString("discount"));
        String picture =JSONObject.parseObject(json).getString("picture");
        String name =JSONObject.parseObject(json).getString("name");
        int stock = Integer.parseInt(JSONObject.parseObject(json).getString("stock"));
        String describe = JSONObject.parseObject(json).getString("describe");
        Double cost = Double.valueOf(JSONObject.parseObject(json).getString("cost"));

        Costume costume =new Costume(price,name,picture,cost,describe,category,stock,discount);
        System.out.println(costume);
        model.addAttribute("costumeInfo", costume);
        System.out.println(costume);
        //验证通过后提交到数据库--此处略
        int infor = costumeService.addCostume(costume);
        // 页面转发
        return "costume/listCostume";
    }

}
