package com.example.bookstore.service;

import com.example.bookstore.entity.ShopBook;

import java.util.List;

public interface CartService {
    List<ShopBook> selectShopBooksByCusid(int cusid);

    String selectBookNameById(int bookid);

    String selectBookPicById(int bookid);

    int deleteShopbook(ShopBook shopBook);

    int selectBookidByName(String name);

    int updateCartMount(ShopBook shopBook);

    ShopBook selectShopbookByCusidAndBookid(ShopBook shopBook);
}
