package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.BookComment;
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
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public String details(HttpServletRequest request ,HttpSession session,Model model) {
       String string = request.getParameter("id");
       int id = Integer.parseInt(string);
       //加载图书基本信息 bookinfo
       Book book = bookService.selectBookById(id);
       model.addAttribute("book",book);
       List<BookComment> comments = bookService.selectCommentsBybookid(id);
        System.out.println(comments);
        model.addAttribute("comments",comments);

        return "details" ;
    }



}
