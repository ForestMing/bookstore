package com.example.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class loginout {

    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public String loginout(Model model, HttpSession session) {
        session.removeAttribute("loginname");
        return "redirect:index";
    }


}
