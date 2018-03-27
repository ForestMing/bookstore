package com.example.bookstore.service;

import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> selectBookByTypeName (String type);

    List<Book> selectBookByName(String name );

    List<Book> selectPopularBooks();

    Book selectBookById(int bookId);
}
