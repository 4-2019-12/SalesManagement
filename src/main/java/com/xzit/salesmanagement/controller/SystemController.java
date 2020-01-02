package com.xzit.salesmanagement.controller;


import com.xzit.salesmanagement.entity.Jurisdiction;
import com.xzit.salesmanagement.entity.Users;
import com.xzit.salesmanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SystemController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/")
    public String logins() {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        return "login";
    }

    @RequestMapping(value = "/main")
    public String login(String username, String password, Model model,HttpSession session) {

        Users user = null;
        user = loginService.findByUsername(username);
        List<Jurisdiction> jurisdictions = loginService.getJurisdiction(user.getRoleId());
        if (user == null||(!password.equals(user.getPassword()))) {
            model.addAttribute("info", "用户名密码不正确！");
            return "login";
        }
        model.addAttribute("user", user);
        model.addAttribute("jurisdictions",jurisdictions);
        session.setAttribute("user",user.getUsername());
        return "homePage";

    }

    @RequestMapping(value = "/test")
    public String test() {
        return "demo";
    }
}
