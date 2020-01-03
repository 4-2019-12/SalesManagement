package com.xzit.salesmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzit.salesmanagement.entity.Jurisdiction;
import com.xzit.salesmanagement.entity.Roles;
import com.xzit.salesmanagement.entity.Roles_Jurisdiction;
import com.xzit.salesmanagement.service.JurisdictionService;
import com.xzit.salesmanagement.service.LoginService;
import com.xzit.salesmanagement.service.RoleService;
import com.xzit.salesmanagement.service.Roles_JurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class JurisdictionController {

    @Autowired
    private JurisdictionService jurisdictionService;

    @Autowired
    private Roles_JurisdictionService roles_jurisdictionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("jurisdiction")
    public String jurisdiction(Model model){
//        List<Roles_Jurisdiction> roles_jurisdictions = jurisdictionService.getRoles_Jurisdiction();
        List<Jurisdiction> jurisdictions = jurisdictionService.getJurisdictions();
        List<Roles> roles = roleService.getRoles();
        List<Integer> sale = new ArrayList<Integer>();
        List<Integer> manager = new ArrayList<Integer>();
        List<Integer> admin = new ArrayList<Integer>();
        System.out.println();
        for(Roles rol:roles){
            rol.setJurisdictions(loginService.getJurisdiction(rol.getId()));
            for (Jurisdiction j:rol.getJurisdictions()){
                if(rol.getId()==1){
                    sale.add(j.getId());
                }if(rol.getId()==2){
                    manager.add(j.getId());
                }if(rol.getId()==3){
                    admin.add(j.getId());
                }
            }
        }
//        for(Roles_Jurisdiction r:roles_jurisdictions){
//            r.setJurisdictions(jurisdictionService.getJurisdictionById(r.getJurisdiction()));
//            r.setRoles(roleService.getRoleById(r.getRoleId()));
//        }
        model.addAttribute("s",sale);
        model.addAttribute("m",manager);
        model.addAttribute("a",admin);
        model.addAttribute("roles",roles);
//        model.addAttribute("roles_jurisdictions",roles_jurisdictions);
        model.addAttribute("jurisdictions",jurisdictions);
//        System.out.println(roles_jurisdictions);
        return "administration/jurisdiction";
    }

    @RequestMapping(value = "/updateJurisdiction", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String update(@RequestBody String value)throws Exception{
        int id = Integer.valueOf(value.substring(value.lastIndexOf("=")+1));
        int key = id/100;
        if(id%100==0){
            int i=roles_jurisdictionService.add(1,key);
        }else if (id%100==1){
            int i=roles_jurisdictionService.add(2,key);
        }else {
            int i=roles_jurisdictionService.add(3,key);
        }
        return "success";
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String del(@RequestBody String value)throws Exception{
        int id = Integer.valueOf(value.substring(value.lastIndexOf("=")+1));
        int key = id/100;
        if(id%100==0){
            int i=roles_jurisdictionService.del(1,key);
        }else if (id%100==1){
            int i=roles_jurisdictionService.del(2,key);
        }else {
            int i=roles_jurisdictionService.del(3,key);
        }
        return "success";
    }
}
