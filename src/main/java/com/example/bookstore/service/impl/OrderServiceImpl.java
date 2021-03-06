package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Order;
import com.example.bookstore.mapper.OrderMapper;
import com.example.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper ;

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public List<Order> selectAllOrderByCusid(int cusid) {
        return orderMapper.selectAllOrderByCusid(cusid);
    }
}
