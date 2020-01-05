package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Category;
import com.xzit.salesmanagement.entity.Users;
import com.xzit.salesmanagement.service.CategoryService;
import com.xzit.salesmanagement.util.CourseDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    /**
     * 跳转类别列表
     * @return
     */
    @RequestMapping("")
    public String category(){
        return "category/listCategory";
    }

    /**
     * 获取类别信息
     * @param page
     * @param rows
     * @param states
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public CourseDatagrid<Category> orderlist(
            @RequestParam(value = "page",defaultValue = "1",required = false) int page,
            @RequestParam(value = "limit",defaultValue = "10",required = false) int rows,
            String states){
        List<Category> categoryList = categoryService.listCategory();
        List<Category> categoryList1 = new ArrayList<>();
        for (int i=page*rows-rows;i<page*rows&&i<categoryList.size();i++){
            categoryList1.add(categoryList.get(i));
        }
        CourseDatagrid<Category> courseDatagrid = new CourseDatagrid<Category>();
        courseDatagrid.setCode(0);
        courseDatagrid.setCount(categoryList.size());
        courseDatagrid.setData(categoryList1);
        courseDatagrid.setMsg("类别信息查询结果");
        return courseDatagrid;
    }

    /**
     * 跳转编辑和添加页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String  edit(@PathVariable("id") int id, Model model){
        Category category = categoryService.getCategory(id);
        model.addAttribute("category",category);
        model.addAttribute("categoryId",id);
        return "category/editCategory";
    }

    /**
     * 添加或者编辑类别，对数据库进行更新
     * @return
     * @throws Exception
     */
    @Transactional  //加入事务，若出错回滚数据库
    @RequestMapping(value = "/ajaxValid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String submit(@RequestBody JSONObject jsonParam
    ) throws Exception {
        String json = jsonParam.toJSONString();
        int id = Integer.parseInt(JSONObject.parseObject(json).getString("id"));
        String name = JSONObject.parseObject(json).getString("name");
        String describes = JSONObject.parseObject(json).getString("describes");
        Category category = new Category();
        category.setName(name);
        category.setDescribes(describes);
        if(id!=0){
            category.setId(id);
            categoryService.update(category);
        }else {
            categoryService.add(category);
        }
        return "category/listCategory";
    }
}