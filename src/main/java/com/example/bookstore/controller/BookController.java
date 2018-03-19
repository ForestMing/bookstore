package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService ;

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("book",new Book());
        return "index" ;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String indexbook(Model model) {
        model.addAttribute("book",new Book());
        return "index" ;
    }

    //按类型查找图书
    @RequestMapping(value = "/findByType" ,method = RequestMethod.POST)
    public String findByType(@ModelAttribute String type, Model model){
        List<Book> bookList = bookService.selectBookByTypeName(type);
        model.addAttribute("books",bookList);
        return "result";
    }

    //按书名查找图书
    @RequestMapping(value = "/findByName" ,method = RequestMethod.POST)
    public String findByName(@ModelAttribute(value="book") Book book,Model model) {
        System.out.println(book.getBookname());
        List<Book> books = bookService.selectBookByName(book.getBookname());
        model.addAttribute("books",books);
        System.out.println("BookController 发送");
        return "index";
    }
}
