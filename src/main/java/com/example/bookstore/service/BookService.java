package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.BookComment;
import com.example.bookstore.entity.BookDetails;

import java.util.List;

public interface BookService {
    List<Book> selectBookByTypeName (String type);

    List<Book> selectBookByName(String name );

    List<Book> selectPopularBooks();

    Book selectBookById(int bookId);

    List<BookComment> selectCommentsBybookid (int bookid);

    BookDetails selectDetailsBybookid(int boodid) ;

    List<Book> selectNewBook();

    List<Book> selectBestSaleBook () ;

    List<Book> selectPopularBooksPlus();

    List<Book> selectNewBookPlus();

    List<Book> selectBestSaleBookPlus();
}
