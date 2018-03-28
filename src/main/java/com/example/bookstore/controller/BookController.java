package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    private BookService bookService ;

    //载入主页
    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(Model model,HttpSession session) {
        model.addAttribute("book",new Book());
        //判断用户登陆状态
        if(session.getAttribute("loginid")!= null) {
            String name = (String) session.getAttribute("loginname");
            int uid = (Integer) session.getAttribute("loginid");
            System.out.println("index收到login用户：" + name);
            System.out.println("index收到login用户id：" + uid);
            model.addAttribute("username", name);
        }
        //按浏览量自动推送
        List<Book> popbooks = bookService.selectPopularBooks();
        model.addAttribute("popbooks",popbooks);
        return "index" ;
    }


    @RequestMapping(value="/", method= RequestMethod.GET)
    public String indexbook(Model model) {
        model.addAttribute("book",new Book());
        return "index" ;
    }

    //导航栏按类型查找图书
    @RequestMapping("findByType")
    public ModelAndView findByType(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String type = request.getParameter("type") ;
        System.out.println("findByType"+type);
        List<Book> books = bookService.selectBookByTypeName(type);
        System.out.println("查到book："+books);
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("books",books);
        return modelAndView ;
    }

    //搜索框按书名查找图书
    @RequestMapping(value="findByName")
    public ModelAndView findByName(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String name = request.getParameter("name") ;
        System.out.println("findByName"+name);
        List<Book> books = bookService.selectBookByName(name);
        System.out.println("查到book："+books);
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("books",books);
        return modelAndView ;
    }






  /*  //按书名查找图书(不使用ajax）
    @RequestMapping(value = "/findByName" ,method = RequestMethod.POST)
    public String findByName(@ModelAttribute(value="book") Book book,Model model) {
        System.out.println(book.getBookname());
        List<Book> books = bookService.selectBookByName(book.getBookname());
        model.addAttribute("books",books);
        System.out.println("BookController 发送");
        return "index";
    }
    */
}
