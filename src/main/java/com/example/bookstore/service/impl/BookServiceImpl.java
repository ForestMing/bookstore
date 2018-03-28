package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.BookComment;
import com.example.bookstore.entity.BookDetails;
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

        return bookMapper.selectBookByName(name);
    }

    @Override
    public List<Book> selectPopularBooks() {
        return  bookMapper.selectPopularBooks();
    }

    @Override
    public Book selectBookById(int bookId) {
       return bookMapper.selectBookById(bookId);
    }

    @Override
    public List<BookComment> selectCommentsBybookid(int bookid) {
       return bookMapper.selectCommentsBybookid(bookid);
    }

    @Override
    public BookDetails selectDetailsBybookid(int boodid) {
        return bookMapper.selectDetailsBybookid(boodid);
    }

}
