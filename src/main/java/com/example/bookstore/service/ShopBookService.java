package com.example.bookstore.service;

import com.example.bookstore.entity.ShopBook;

public interface ShopBookService {
    int addToCart(ShopBook shopBook);

    int ifExistItem(ShopBook shopBook);

    int updateMount(ShopBook shopBook);

}
