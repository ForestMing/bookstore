package com.example.bookstore.controller;

import com.example.bookstore.entity.Person;
import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.service.CustomerService;
import com.example.bookstore.service.ShopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
public class ShopBookController {
    @Autowired
    private ShopBookService shopBookService ;


    @RequestMapping(value = "/addCart" ,method = RequestMethod.POST)
    public @ResponseBody String add(@RequestBody ShopBook shopBook, HttpSession session , HttpServletResponse response)
            throws Exception
    {
        if (session.getAttribute("loginid") == null) {
            System.out.println("ShopBookController:loginid == null ");
            //response.sendRedirect("login");
            return "555";
        }else {
            System.out.println("ShopBookController:loginid != null ");
            System.out.println(shopBook);
            int flag = shopBookService.addToCart(shopBook); System.out.println("Flag:(1为成功)"+flag);
            return Integer.toString(flag) ;
        }
    }

}

