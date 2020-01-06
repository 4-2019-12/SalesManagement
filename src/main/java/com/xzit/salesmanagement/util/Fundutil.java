package com.xzit.salesmanagement.util;

import com.xzit.salesmanagement.entity.Fund;
import com.xzit.salesmanagement.entity.Orders;
import com.xzit.salesmanagement.entity.Users;
import com.xzit.salesmanagement.service.OrdersService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Fundutil {
    public static List<Fund> getFund(int date,HttpSession session,OrdersService ordersService){
        Users users =(Users)session.getAttribute("user");
        List<Orders> ordersList = ordersService.findAllByUserIdAndState(users.getId(),"completed");
        List<Fund> funds = new ArrayList<Fund>();
        for(Orders o:ordersList){
            String id = o.getId();
            String flag ="0" ;
            for(Fund f:funds){
                if(id.substring(0,date).equals(f.getId()) ){
                    flag=id.substring(0,date);
                    f.setTotal(f.getTotal()+o.getTotal());
                    f.setNumber(f.getNumber()+1);
                }
            }
            if(flag.equals("0")){
                Fund fund = new Fund();
                fund.setNumber(0);
                fund.setTotal(0);
                fund.setId(id.substring(0,date));
                fund.setNumber(fund.getNumber()+1);
                fund.setTotal(fund.getTotal()+o.getTotal());
                funds.add(fund);
            }
        }
        return funds;
    }
}
