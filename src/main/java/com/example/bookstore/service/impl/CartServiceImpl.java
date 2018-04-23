package com.example.bookstore.service.impl;

import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.mapper.ShopBookMapper;
import com.example.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private ShopBookMapper shopBookMapper ;


    @Override
    public List<ShopBook> selectShopBooksByCusid(int cusid) {
        return shopBookMapper.selectShopBooksByCusid(cusid);
    }

    @Override
    public String selectBookNameById(int bookid) {
        return shopBookMapper.selectBookNameById(bookid);
    }

    @Override
    public String selectBookPicById(int bookid) {
        return shopBookMapper.selectBookPicById(bookid);
    }

    @Override
    public int deleteShopbook(ShopBook shopBook) {
        return shopBookMapper.deleteShopbook(shopBook);
    }

    @Override
    public int selectBookidByName(String name) {
        return shopBookMapper.selectBookidByName(name);
    }
}
