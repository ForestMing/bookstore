package com.example.bookstore.controller;


import com.example.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService ;

    @RequestMapping("/orders")
    public String orders(Model model) {

        return "/orders";
    }

}
