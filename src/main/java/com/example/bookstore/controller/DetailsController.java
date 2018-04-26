package com.example.bookstore.controller;

import com.example.bookstore.entity.*;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DetailsController {
    @Autowired
    private BookService bookService ;

    //点击书本条目，载入书本详情页面
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(HttpServletRequest request, HttpSession session, Model model) {
        String string = request.getParameter("id");
        int id = Integer.parseInt(string);
        //判断用户登陆状态
        if(session.getAttribute("loginid") != null ){
            String name = (String) session.getAttribute("loginname");
            int uid = (Integer) session.getAttribute("loginid");
            System.out.println("Details收到login用户name：" + name);
            System.out.println("Details收到login用户id：" + uid);
            //封装到cus对象
            Customer cus = new Customer();
            cus.setCustomerid(uid);
            cus.setCustomername(name);
            model.addAttribute("currentCus",cus);
        }else {
            System.out.println("当前未登录！！！！！！！！！！！！！！！！！");
            Customer cus = new Customer();
            cus.setCustomerid(0);
            model.addAttribute("currentCus",cus);

        }
        //加载图书基本信息 bookinfo
        Book book = bookService.selectBookById(id);
        model.addAttribute("book", book);
        //加载图书评论
        List<BookComment> comments = bookService.selectCommentsBybookid(id);
        System.out.println(comments);
        model.addAttribute("comments", comments);
        //加载图书详情信息
        BookDetails bookDetails = bookService.selectDetailsBybookid(id);
        System.out.println(bookDetails);
        model.addAttribute("details",bookDetails);
        //模板写入shopbook模型
        model.addAttribute("shopbook",new ShopBook());

        return "details";
    }



}
