package com.xzit.salesmanagement.controller;

import com.xzit.salesmanagement.entity.Costume;
import com.xzit.salesmanagement.service.CostumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustumeController {

    @Autowired
    CostumeService costumeService;

    @RequestMapping(value = "/viewProducts")
    public String viewProducts(Model model){
        List<Costume> costumeList;
        costumeList = costumeService.listCostumes();
        model.addAttribute("costumeList",costumeList);
        return "viewProducts";
    }
}
