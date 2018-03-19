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
        return bookMapper.selectBookByTypename(type);
    }

    @Override
    public List<Book> selectBookByName(String name) {
        System.out.println("BookServiceImpl 发送");
        List<Book> temp = bookMapper.selectBookByName(name);
        for(Book b : temp)
        {
            System.out.println(b);
        }
        return bookMapper.selectBookByName(name);
    }
}
