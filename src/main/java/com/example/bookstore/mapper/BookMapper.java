package com.example.bookstore.mapper;

import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookMapper {

    List<Book> selectBookByTypename(String type) ;

    List<Book> selectBookByName(String name ) ;
}