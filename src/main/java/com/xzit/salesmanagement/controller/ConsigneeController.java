package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Consignee;
import com.xzit.salesmanagement.entity.Users;
import com.xzit.salesmanagement.service.ConsigneeService;
import com.xzit.salesmanagement.util.CourseDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/consignee")
public class ConsigneeController {

    @Autowired
    ConsigneeService consigneeService;

    @RequestMapping("")
    public String consignee(){
        return "consignee/consigneelist";
    }

    /**
     * 获取客户信息列表
     * @param page
     * @param rows
     * @param states
     * @param session
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public CourseDatagrid<Consignee> list(
            @RequestParam(value = "page",defaultValue = "1",required = false) int page,
            @RequestParam(value = "limit",defaultValue = "10",required = false) int rows,
            String states, HttpSession session){
        Users user=(Users) session.getAttribute("user");
        List<Consignee> consigneeList = consigneeService.listConsignee(user.getId());
        List<Consignee> consigneeList1 = new ArrayList<>();
        for (int i=page*rows-rows;i<page*rows&&i<consigneeList.size();i++){
            consigneeList1.add(consigneeList.get(i));
        }
        CourseDatagrid<Consignee> courseDatagrid = new CourseDatagrid<Consignee>();
        courseDatagrid.setCode(0);
        courseDatagrid.setCount(consigneeList.size());
        courseDatagrid.setData(consigneeList1);
        courseDatagrid.setMsg("客户信息查询结果");
        return courseDatagrid;
    }

    /**
     * 跳转编辑和添加页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String toedit(@PathVariable("id") int id, Model model){
        Consignee consignee = consigneeService.findById(id);
        model.addAttribute("consignee",consignee);
        model.addAttribute("consigneeId",id);
        return "consignee/editConsignee";
    }


    /**
     *   为订单添加商品 若无订单信息，根据时间和用户创建订单
     * @param jsonParam
     * @return
     * @throws Exception
     */
    @Transactional  //加入事务，若出错回滚数据库
    @RequestMapping(value = "/ajaxValid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String submit(@RequestBody JSONObject jsonParam,HttpSession session
    ) throws Exception {
        int info;
        String json = jsonParam.toJSONString();
        int id = Integer.parseInt(JSONObject.parseObject(json).getString("id"));
        String name = JSONObject.parseObject(json).getString("name");
        String mobile = JSONObject.parseObject(json).getString("mobile");
        int role =Integer.parseInt(JSONObject.parseObject(json).getString("role")) ;
        String address = JSONObject.parseObject(json).getString("address");
        Consignee consignee = new Consignee();
        consignee.setName(name);
        consignee.setMobile(mobile);
        consignee.setRole(role);
        consignee.setAddress(address);
        if(id!=0){
            consignee.setId(id);
            consigneeService.update(consignee);
        }else {
            int userId = ((Users)session.getAttribute("user")).getId();
            consignee.setUserId(userId);
            consigneeService.add(consignee);
        }
        return "consignee/consigneelist";
    }

}
