package com.example.bookstore.entity;

public class BookType {
    private Integer booktypeid;

    private String booktypename;

    public Integer getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(Integer booktypeid) {
        this.booktypeid = booktypeid;
    }

    public String getBooktypename() {
        return booktypename;
    }

    public void setBooktypename(String booktypename) {
        this.booktypename = booktypename == null ? null : booktypename.trim();
    }
}