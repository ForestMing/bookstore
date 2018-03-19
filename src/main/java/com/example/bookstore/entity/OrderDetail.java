package com.example.bookstore.entity;

public class OrderDetail {
    private Integer orderdetailid;

    private Integer id;

    private Order order;

    private Integer bookid;

    private Integer ordermount;

    private String poststatus;

    private String recevstatus;

    private Long sigletotalprice;

    public Integer getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(Integer orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public String getPoststatus() {
        return poststatus;
    }

    public void setPoststatus(String poststatus) {
        this.poststatus = poststatus == null ? null : poststatus.trim();
    }

    public String getRecevstatus() {
        return recevstatus;
    }

    public void setRecevstatus(String recevstatus) {
        this.recevstatus = recevstatus == null ? null : recevstatus.trim();
    }

    public Long getSigletotalprice() {
        return sigletotalprice;
    }

    public void setSigletotalprice(Long sigletotalprice) {
        this.sigletotalprice = sigletotalprice;
    }
}