package com.example.bookstore.controller;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.entity.Manager;
import com.example.bookstore.service.CustomerService;
import com.example.bookstore.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/Manager", method = RequestMethod.GET)
    public String Manager(Model model, HttpSession session ) {
        String managerName = (String) session.getAttribute("managername");
        System.out.println("Manager收到login用户："+managerName);
        return "Manager";
    }


    @RequestMapping(value = "/ManagerLogin", method = RequestMethod.GET)
    public String Managerlogin(Model model) {
        model.addAttribute("manager", new Manager());
        return "ManagerLogin";
    }

    @RequestMapping(value = "/ManagerIn", method = RequestMethod.POST)
    public String loginAction(@ModelAttribute Manager manager, HttpSession session, Model model) {
        int Match = 0;
        Match = managerService.loginManager(manager);
        System.out.println("匹配？0不匹配:" + Match);
        if (Match == 1) {
            session.setAttribute("managername", manager.getAdminname());
            return "redirect:Manager";
        } else {
            String errorinfo = "管理员用户名或密码错误";
            model.addAttribute("errorInfo", errorinfo);
            return "ManagerLogin";
        }
    }

}
