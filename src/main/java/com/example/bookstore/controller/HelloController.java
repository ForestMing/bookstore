package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * Created by 69077 on 2017/11/17.
 */
@Controller
public class HelloController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/details")
    public String details(){
        return "/details" ;
    }


    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("book",new Book());
        //推送信息-新书
        String message1 = "新书上架";
        model.addAttribute("message1",message1) ;
        List<Book> newbooks = bookService.selectNewBook() ;
        System.out.println("新----------------------------------:"+newbooks);
        model.addAttribute("newbooks",newbooks);

        //推送信息-浏览量高书
        String message2 = "热门关注";
        model.addAttribute("message2",message2) ;
        List<Book> popbooks = bookService.selectPopularBooks();
        System.out.println("热-----------------------------        ："+popbooks);
        model.addAttribute("popbooks",popbooks);

        //推送信息-销售量高书
        String message3 = "畅销书籍";
        model.addAttribute("message3",message3) ;
        List<Book> salebooks = bookService.selectBestSaleBook();
        System.out.println("销-------------------------------------：" +salebooks);
        model.addAttribute("salebooks",salebooks);

        return "/test";
    }

    @RequestMapping("/userCenter")
    public String userCenter() {
        return "/userCenter";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "/cart";
    }

    @RequestMapping("/rankingList")
    public String rankingList() {
        return "/rankingList";
    }



}
