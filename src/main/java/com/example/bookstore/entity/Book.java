package com.example.bookstore.entity;

import java.util.Date;

public class Book {
    private Integer bookid;

    private BookType booktype;

    private String bookname;

    private String bookpress;

    private Date bookpubdate;

    private Double booksize;

    private String bookversion;

    private String bookauthor;

    private String booktanslor;

    private String bookisbn;

    private Integer bookpages;

    private Long bookprprice;

    private Integer bookdealmount;

    private Integer booklookmount;

    private Long bookdiscount;

    private String bookpic;

    private Integer bookstoremount;

    private Date bookstoretime;

    private String bookpackstyle;

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", booktype=" + booktype +
                ", bookname='" + bookname + '\'' +
                ", bookpress='" + bookpress + '\'' +
                ", bookpubdate=" + bookpubdate +
                ", booksize=" + booksize +
                ", bookversion='" + bookversion + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", booktanslor='" + booktanslor + '\'' +
                ", bookisbn='" + bookisbn + '\'' +
                ", bookpages=" + bookpages +
                ", bookprprice=" + bookprprice +
                ", bookdealmount=" + bookdealmount +
                ", booklookmount=" + booklookmount +
                ", bookdiscount=" + bookdiscount +
                ", bookpic='" + bookpic + '\'' +
                ", bookstoremount=" + bookstoremount +
                ", bookstoretime=" + bookstoretime +
                ", bookpackstyle='" + bookpackstyle + '\'' +
                '}';
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public BookType getBooktype() {
        return booktype;
    }

    public void setBooktype(BookType booktype) {
        this.booktype = booktype;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBookpress() {
        return bookpress;
    }

    public void setBookpress(String bookpress) {
        this.bookpress = bookpress == null ? null : bookpress.trim();
    }

    public Date getBookpubdate() {
        return bookpubdate;
    }

    public void setBookpubdate(Date bookpubdate) {
        this.bookpubdate = bookpubdate;
    }

    public Double getBooksize() {
        return booksize;
    }

    public void setBooksize(Double booksize) {
        this.booksize = booksize;
    }

    public String getBookversion() {
        return bookversion;
    }

    public void setBookversion(String bookversion) {
        this.bookversion = bookversion == null ? null : bookversion.trim();
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor == null ? null : bookauthor.trim();
    }

    public String getBooktanslor() {
        return booktanslor;
    }

    public void setBooktanslor(String booktanslor) {
        this.booktanslor = booktanslor == null ? null : booktanslor.trim();
    }

    public String getBookisbn() {
        return bookisbn;
    }

    public void setBookisbn(String bookisbn) {
        this.bookisbn = bookisbn == null ? null : bookisbn.trim();
    }

    public Integer getBookpages() {
        return bookpages;
    }

    public void setBookpages(Integer bookpages) {
        this.bookpages = bookpages;
    }

    public Long getBookprprice() {
        return bookprprice;
    }

    public void setBookprprice(Long bookprprice) {
        this.bookprprice = bookprprice;
    }

    public Integer getBookdealmount() {
        return bookdealmount;
    }

    public void setBookdealmount(Integer bookdealmount) {
        this.bookdealmount = bookdealmount;
    }

    public Integer getBooklookmount() {
        return booklookmount;
    }

    public void setBooklookmount(Integer booklookmount) {
        this.booklookmount = booklookmount;
    }

    public Long getBookdiscount() {
        return bookdiscount;
    }

    public void setBookdiscount(Long bookdiscount) {
        this.bookdiscount = bookdiscount;
    }

    public String getBookpic() {
        return bookpic;
    }

    public void setBookpic(String bookpic) {
        this.bookpic = bookpic == null ? null : bookpic.trim();
    }

    public Integer getBookstoremount() {
        return bookstoremount;
    }

    public void setBookstoremount(Integer bookstoremount) {
        this.bookstoremount = bookstoremount;
    }

    public Date getBookstoretime() {
        return bookstoretime;
    }

    public void setBookstoretime(Date bookstoretime) {
        this.bookstoretime = bookstoretime;
    }

    public String getBookpackstyle() {
        return bookpackstyle;
    }

    public void setBookpackstyle(String bookpackstyle) {
        this.bookpackstyle = bookpackstyle == null ? null : bookpackstyle.trim();
    }
}