package com.example.bookstore.controller;

import com.example.bookstore.entity.BookComment;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CommunityController {
    @Autowired
    private BookService bookService ;

    @RequestMapping("/community")
    public String community(Model model) {
        model.addAttribute("comments",new ArrayList<BookComment>());
        return "/community";
    }

}
