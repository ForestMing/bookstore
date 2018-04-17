package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by 69077 on 2017/11/17.
 */
@Controller
public class HelloController {

    @RequestMapping("/details")
    public String details(){
        return "/details" ;
    }

    @RequestMapping("/community")
    public String community() {
        return "/community";
    }


    @RequestMapping("/userCenter")
    public String userCenter() {
        return "/userCenter";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "/cart";
    }

    @RequestMapping("/orders")
    public String orders() {
        return "/orders";
    }

    @RequestMapping("/rankingList")
    public String rankingList() {
        return "/rankingList";
    }

    @RequestMapping("/conditional")
    public String conditional(){
        return "/conditional";
    }

}
