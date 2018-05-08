package com.example.bookstore.mapper;

import com.example.bookstore.entity.Order;

import java.util.List;

public interface OrderMapper {

    int insertOrder(Order order) ;

    List<Order> selectAllOrderByCusid(int cusid) ;

}