package com.example.bookstore.entity;

import java.math.BigDecimal;

public class ShopBook{
    public ShopBook(){
    }

    @Override
    public String toString() {
        return "ShopBook{" +
                "customerid=" + customerid +
                ", bookid=" + bookid +
                ", ordermount=" + ordermount +
                ", price=" + price +
                ", ispaid='" + ispaid + '\'' +
                '}';
    }

    private Integer customerid ;

    private Integer bookid ;

    private Integer ordermount;

    private float price;

    private String ispaid;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getOrdermount() {
        return ordermount;
    }

    public void setOrdermount(Integer ordermount) {
        this.ordermount = ordermount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIspaid() {
        return ispaid;
    }

    public void setIspaid(String ispaid) {
        this.ispaid = ispaid == null ? null : ispaid.trim();
    }
}