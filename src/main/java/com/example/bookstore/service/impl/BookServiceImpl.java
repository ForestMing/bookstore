package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Book;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("BookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper ;

    @Override
    public List<Book> selectBookByTypeName(String type) {
        List<Book> L = bookMapper.selectBookByTypename(type) ;
        for(Book b : L)
        {
            System.out.println("类型："+type+","+b);
        }
        return bookMapper.selectBookByTypename(type);
    }

    @Override
    public List<Book> selectBookByName(String name) {
        List<Book> temp = bookMapper.selectBookByName(name);
        for(Book b : temp)
        {
            System.out.println("关键字："+name+","+b);
        }
        return bookMapper.selectBookByName(name);
    }
}
