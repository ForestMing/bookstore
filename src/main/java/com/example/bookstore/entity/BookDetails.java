package com.example.bookstore.entity;

public class BookDetails {
    public BookDetails(){
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "bookid=" + bookid +
                ", details1='" + details1 + '\'' +
                ", details2='" + details2 + '\'' +
                ", details3='" + details3 + '\'' +
                ", details4='" + details4 + '\'' +
                '}';
    }

    private int bookid ;
    private String details1 ;
    private String details2 ;
    private String details3 ;
    private String details4 ;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getDetails1() {
        return details1;
    }

    public void setDetails1(String details1) {
        this.details1 = details1;
    }

    public String getDetails2() {
        return details2;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }

    public String getDetails3() {
        return details3;
    }

    public void setDetails3(String details3) {
        this.details3 = details3;
    }

    public String getDetails4() {
        return details4;
    }

    public void setDetails4(String details4) {
        this.details4 = details4;
    }
}
