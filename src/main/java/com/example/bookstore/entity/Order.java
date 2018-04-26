package com.example.bookstore.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String orderid;
    private int customerid ;
    private Date orderdate;
    private Integer ordermount;
    private String message;
    private String postmethod;
    private String paymethod;
    private String recevername;
    private String receveraddr;
    private String recevertel;
    private String memo;
    private float totalprice;

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", customerid=" + customerid +
                ", orderdate=" + orderdate +
                ", ordermount=" + ordermount +
                ", message='" + message + '\'' +
                ", postmethod='" + postmethod + '\'' +
                ", paymethod='" + paymethod + '\'' +
                ", recevername='" + recevername + '\'' +
                ", receveraddr='" + receveraddr + '\'' +
                ", recevertel='" + recevertel + '\'' +
                ", memo='" + memo + '\'' +
                ", totalprice=" + totalprice +
                '}';
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
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

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }
}