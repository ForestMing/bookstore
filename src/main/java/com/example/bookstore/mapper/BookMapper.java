package com.example.bookstore.mapper;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.BookComment;
import com.example.bookstore.entity.BookDetails;

import java.util.List;

public interface BookMapper {

    List<Book> selectBookByTypename(String type) ;

    List<Book> selectBookByName(String name ) ;

    List<Book> selectPopularBooks();

    Book selectBookById(int bookId) ;

    List<BookComment> selectCommentsBybookid (int bookid);

    BookDetails selectDetailsBybookid(int bookid);
}