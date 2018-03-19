package com.example.bookstore.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String orderid;

    private Integer id;

    private Customer customer;

    private Date orderdate;

    private Integer ordermount;

    private String message;

    private String postmethod;

    private String paymethod;

    private String recevername;

    private String receveraddr;

    private String recevertel;

    private String memo;

    private BigDecimal totalprice;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getOrdermount() {
        return ordermount;
    }

    public void setOrdermount(Integer ordermount) {
        this.ordermount = ordermount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getPostmethod() {
        return postmethod;
    }

    public void setPostmethod(String postmethod) {
        this.postmethod = postmethod == null ? null : postmethod.trim();
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod == null ? null : paymethod.trim();
    }

    public String getRecevername() {
        return recevername;
    }

    public void setRecevername(String recevername) {
        this.recevername = recevername == null ? null : recevername.trim();
    }

    public String getReceveraddr() {
        return receveraddr;
    }

    public void setReceveraddr(String receveraddr) {
        this.receveraddr = receveraddr == null ? null : receveraddr.trim();
    }

    public String getRecevertel() {
        return recevertel;
    }

    public void setRecevertel(String recevertel) {
        this.recevertel = recevertel == null ? null : recevertel.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }
}