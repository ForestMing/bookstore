package com.example.bookstore.service.impl;

import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.mapper.ShopBookMapper;
import com.example.bookstore.service.ShopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ShopBookService")
public class ShopBookServiceImpl implements ShopBookService{
    @Autowired
    private ShopBookMapper shopBookMapper ;


    @Override
    public int addToCart(ShopBook shopBook) {
        return shopBookMapper.addToCart(shopBook);
    }

    @Override
    public int ifExistItem(ShopBook shopBook) {
        return shopBookMapper.ifExistItem(shopBook);
    }

    @Override
    public int updateMount(ShopBook shopBook) {
        return shopBookMapper.updateMount(shopBook);
    }

    @Override
    public int selectBookStoremountById(int bookid) {
        return shopBookMapper.selectBookStoremountById(bookid);
    }


}
