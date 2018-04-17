package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ConditionalController {
    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/conditional" , method = RequestMethod.GET)
//    public String conditional(Model model,HttpSession session){
//        model.addAttribute("book",new Book());
//        return "conditional";
//    }

    @RequestMapping(value = "/byCondi" , method = RequestMethod.POST)
    public String bycondi(Model model, HttpServletRequest request,HttpSession session) throws Exception {
        System.out.println("Enter byCondi");
        //搜索框按书名查找图书
        String condition = request.getParameter("condi1");
        System.out.println("conditional:" + condition);
        List<Book> books = bookService.selectBookByName(condition);
        System.out.println("byCondi查到book：" + books);
        //添加书本信息
        model.addAttribute("books", books);
        //添加查询关键字
        model.addAttribute("keyword",condition);
        //添加查询结果数量
        model.addAttribute("count",books.size());
        //判断用户登陆状态
        if(session.getAttribute("loginid") != null ){
            int uid = (Integer) session.getAttribute("loginid");
            String name = (String) session.getAttribute("loginname");
            System.out.println("Conditional收到login用户name：" + name);
            System.out.println("Conditional收到login用户id：" + uid);
            //封装到cus对象
            Customer cus = new Customer();
            cus.setCustomerid(uid);
            cus.setCustomername(name);
            model.addAttribute("currentCus",cus);
        }else {
            System.out.println("当前未登录！！！！！！！！！！！！！！！！！");
        }
        return "conditional";
    }


}
