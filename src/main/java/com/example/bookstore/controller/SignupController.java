package com.example.bookstore.controller;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SignupController {
    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("customer", new Customer());
        return "signup";
    }


    @RequestMapping(value = "/addCus", method = RequestMethod.POST)
    public String addCus(@ModelAttribute Customer customer,HttpServletResponse response,Model model) {
        int isVaild = customerService.isExistName(customer.getCustomername());
        System.out.println("重复？0不存在:" + isVaild);
        if (isVaild == 0) {
            int flag = 0;
            Customer c = customer ;
            flag = customerService.insertCus(c);
            if (flag == 1) {
                model.addAttribute("account",c.getCustomername());
                String info = "恭喜您注册成功！开始登陆吧！";
                model.addAttribute("info",info);
                return "login";
            } else {
                return "redirect:error";
            }
        } else {
            String errorinfo = "账号已被注册";
            model.addAttribute("errorInfo",errorinfo);
            return "signup";
        }
    }





}
