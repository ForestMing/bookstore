package com.example.bookstore.service;

import com.example.bookstore.entity.Order;

import java.util.List;

public interface OrderService {

    int insertOrder(Order order) ;

    List<Order> selectAllOrderByCusid(int cusid) ;

}
