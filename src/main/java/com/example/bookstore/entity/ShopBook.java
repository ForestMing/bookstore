package com.example.bookstore.entity;

import java.math.BigDecimal;

public class ShopBook extends ShopBookKey {
    private Integer ordermount;

    private BigDecimal price;

    private String ispaid;

    public Integer getOrdermount() {
        return ordermount;
    }

    public void setOrdermount(Integer ordermount) {
        this.ordermount = ordermount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIspaid() {
        return ispaid;
    }

    public void setIspaid(String ispaid) {
        this.ispaid = ispaid == null ? null : ispaid.trim();
    }
}