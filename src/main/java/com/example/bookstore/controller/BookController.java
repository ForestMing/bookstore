package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
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
    @RequestMapping(value="findByType")
    public @ResponseBody List<Book>
     findBookByType(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        System.out.println(request.getParameter("type"));
        List<Book> books = bookService.selectBookByTypeName(request.getParameter("type"));
        System.out.println(books);
        return books ;
    }

    //按书名查找图书
    @RequestMapping(value="findByName")
    public @ResponseBody List<Book>
    findBookByName(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        System.out.println(request.getParameter("name"));
        List<Book> books = bookService.selectBookByName(request.getParameter("name"));
        System.out.println(books);
        return books ;
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
