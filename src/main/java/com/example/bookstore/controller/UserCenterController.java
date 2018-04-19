package com.example.bookstore.controller;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserCenterController {

    @Autowired
    private CustomerMapper customerMapper ;

    //用户个人中心
    @RequestMapping(value = "/userCenter", method = RequestMethod.GET)
    public String cart(Model model, HttpSession session) {

        if (session.getAttribute("loginid") != null) {
            //创建模板对象customer用于更改值
            model.addAttribute("customer",new Customer()) ;
            //获取session用户
            String name = (String) session.getAttribute("loginname");
            int uid = (Integer) session.getAttribute("loginid");
            System.out.println("userCenter收到login用户id：" + uid);
            System.out.println("userCenter收到login用户：" + name);
            //封装到cus对象
            Customer cus = customerMapper.getCusInfoById(uid);
            System.out.println(cus);
            //封装到customer对象中用于前台展示
            model.addAttribute("currentCus",cus);
            return "userCenter";
        }else{
            return "redirect:login";
        }

    }
}
