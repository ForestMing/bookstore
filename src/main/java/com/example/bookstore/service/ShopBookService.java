package com.example.bookstore.service;

import com.example.bookstore.entity.ShopBook;

import java.util.List;

public interface ShopBookService {
    int addToCart(ShopBook shopBook);

    int ifExistItem(ShopBook shopBook);

    int updateMount(ShopBook shopBook);

    int selectBookStoremountById(int bookid);


}
