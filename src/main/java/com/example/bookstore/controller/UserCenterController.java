package com.example.bookstore.controller;

import com.example.bookstore.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserCenterController {

    //用户个人中心
    @RequestMapping(value = "/userCenter", method = RequestMethod.GET)
    public String cart(Model model, HttpSession session) {
        if (session.getAttribute("loginid") != null) {
            String name = (String) session.getAttribute("loginname");
            int uid = (Integer) session.getAttribute("loginid");
            System.out.println("userCenter收到login用户id：" + uid);
            System.out.println("userCenter收到login用户：" + name);
            //封装到cus对象
            Customer cus = new Customer();
            cus.setCustomerid(uid);
            cus.setCustomername(name);
            //封装到customer对象中用于前台展示
            model.addAttribute("currentCus",cus);
            return "userCenter";
        }else{
            return "redirect:login";
        }

    }
}
