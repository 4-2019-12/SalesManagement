package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xzit.salesmanagement.entity.Category;
import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.entity.Discount;
import com.xzit.salesmanagement.service.CategoryService;
import com.xzit.salesmanagement.service.CostumeService;
import com.xzit.salesmanagement.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CostumeController {

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
    @RequestMapping(value = "/listCostume")//调用类
    public String listCostume(Model model) {
        List<Costume> queryResult = costumeService.findAllByPageF(1, 5);
//        PageInfo<Costume> queryResult = costumeService.findAllByPageS(1, 5);
        PageInfo<Costume> pageInfo = new PageInfo<Costume>(queryResult);
//        System.out.println(queryResult);
//        System.out.println(pageInfo);

//        List<Costume> costumeList;
//        costumeList = costumeService.listCostumes();
        for (Costume c : queryResult) {
            c.setDiscount(discountService.getDiscount(c.getDiscountId()));
            c.setCategory(categoryService.getCategory(c.getCategoryId()));
        }
//        model.addAttribute("costumeList", costumeList);
        model.addAttribute("costumeList", queryResult);
        model.addAttribute("pageInfo",pageInfo);
        return "costume/listCostume";
    }

    //跳转管理商品页面
    @RequestMapping("/addCostume/{id}")
    public String toAddpage(@PathVariable("id") Integer id, Model model) {

        System.out.println(id);
        Costume costume=null;
        if(!id.equals("0")){
            costume = costumeService.getCostume(id);
        }
        model.addAttribute("costume",costume);
        List<Category> categoryList = categoryService.listCategory();
        List<Discount> discountList = discountService.listDiscount();
        model.addAttribute("discountList", discountList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("flag",id);
        return "costume/addCostume";
    }

    @RequestMapping(value = "/costumeInfo/ajaxValid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addCostume(@RequestBody JSONObject jsonParam
    ) throws Exception {
        int info;
        String json = jsonParam.toJSONString();
        int id = Integer.parseInt(JSONObject.parseObject(json).getString("costumeId"));
        int category=Integer.parseInt(JSONObject.parseObject(json).getString("categoryId"));
        Double price =Double.valueOf(JSONObject.parseObject(json).getString("price"));
        int discount =Integer.parseInt(JSONObject.parseObject(json).getString("discount"));
        String picture =JSONObject.parseObject(json).getString("picture");
        String name =JSONObject.parseObject(json).getString("name");
        int stock = Integer.parseInt(JSONObject.parseObject(json).getString("stock"));
        String describe = JSONObject.parseObject(json).getString("describe");
        Double cost = Double.valueOf(JSONObject.parseObject(json).getString("cost"));
        if(id==0){
            Costume costume =new Costume(price,name,picture,cost,describe,category,stock,discount);
            info = costumeService.addCostume(costume);
        }else {
            Costume costume =new Costume(id,price,name,picture,cost,describe,category,stock,discount);
            info = costumeService.updateCostume(costume);
        }
        System.out.println(info);
        // 页面转发
        return "costume/listCostume";
    }

    @RequestMapping(value = "/delCostume", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delCostume(@RequestBody String costumeId){
        int id = Integer.valueOf(costumeId.substring(costumeId.lastIndexOf("=")+1));
        FileController.deleteFile(costumeService.getCostume(id).getPicture());
        costumeService.delCostumeById(id);
        return "success";
    }

}
