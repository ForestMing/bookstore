package com.example.bookstore.mapper;

import com.example.bookstore.entity.ShopBook;

import java.util.List;

public interface ShopBookMapper {
    int addToCart(ShopBook shopBook);

    int ifExistItem(ShopBook shopBook);

    int updateMount(ShopBook shopBook);

    List<ShopBook> selectShopBooksByCusid(int cusid);

    String selectBookNameById(int bookid);

    String selectBookPicById(int bookid);

    int selectBookidByName(String name );

    int deleteShopbook(ShopBook shopBook);

    int updateCartMount(ShopBook shopBook);

    ShopBook selectShopbookByCusidAndBookid(ShopBook shopBook);

    int selectBookStoremountById(int bookid);
}