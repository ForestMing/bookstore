package com.example.bookstore.service.impl;

import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.mapper.ShopBookMapper;
import com.example.bookstore.service.ShopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ShopBookService")
public class ShopBookServiceImpl implements ShopBookService{
    @Autowired
    private ShopBookMapper shopBookMapper ;


    @Override
    public int addToCart(ShopBook shopBook) {
        return shopBookMapper.addToCart(shopBook);
    }
}
