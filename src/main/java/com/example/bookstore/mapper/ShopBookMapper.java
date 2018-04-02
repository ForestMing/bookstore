package com.example.bookstore.mapper;

import com.example.bookstore.entity.ShopBook;

public interface ShopBookMapper {
    int addToCart(ShopBook shopBook);

    int ifExistItem(ShopBook shopBook);

    int updateMount(ShopBook shopBook);

}