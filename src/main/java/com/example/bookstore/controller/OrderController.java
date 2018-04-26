package com.example.bookstore.controller;


import com.example.bookstore.entity.Customer;
import com.example.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService ;

    //载入orders页面
    @RequestMapping(value = "/orders" , method = RequestMethod.GET)
    public String orders(Model model , HttpSession session) {
        System.out.println("Enter /orders -----------------------------------");
        if (session.getAttribute("loginid") != null) {
            String name = (String) session.getAttribute("loginname");
            int uid = (Integer) session.getAttribute("loginid");
            System.out.println("orders收到login用户：" + name);
            System.out.println("orders收到login用户id：" + uid);
            //封装到cus对象
            Customer cus = new Customer();
            cus.setCustomerid(uid);
            cus.setCustomername(name);
            //封装到customer对象中用于前台展示
            model.addAttribute("currentCus",cus);

            return "orders";
        }else{
            return "redirect:login";
        }

    }

}
