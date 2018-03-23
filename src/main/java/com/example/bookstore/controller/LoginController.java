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

@Controller
public class LoginController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public String loginAction(@ModelAttribute Customer customer, HttpServletResponse response, Model model) {
        int Match = 0;
        Match = customerService.checkCnameAndCpwd(customer);
        System.out.println("匹配？0不匹配:" + Match);
        if (Match == 1) {
                return "index";
        } else {
            String errorinfo = "用户名或密码错误";
            model.addAttribute("errorInfo",errorinfo);
            return "login";
        }
    }
}
