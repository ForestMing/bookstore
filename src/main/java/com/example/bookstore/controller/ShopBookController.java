package com.example.bookstore.controller;

import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.service.ShopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ShopBookController {
    @Autowired
    private ShopBookService shopBookService ;


    @RequestMapping(value = "/addCart" ,method = RequestMethod.POST)
    public @ResponseBody String add(@RequestBody ShopBook shopBook, HttpSession session , HttpServletResponse response)
            throws Exception
    {
        if (session.getAttribute("loginid") == null) {
            System.out.println("ShopBookController:loginid == null ");
            //response.sendRedirect("login");
            return "请注册/登陆！";
        }else {
            System.out.println("ShopBookController:loginid != null ");
            System.out.println(shopBook);
            int isAdded = isExistItem(shopBook);
            if(isAdded == 1 ){
               int updatesinfo =  updatenum(shopBook) ;
               return "修改购物车数目成功！";
            }else {
                int flag = shopBookService.addToCart(shopBook);
                System.out.println("Flag:(1为成功)" + flag);
                return "成功加入购物车！";
            }
        }
    }

    /**
     * 检测是否已存在同一用户同一商品的购物车添加
     * @param shopBook
     * @return shopbook条目。存在则返回1 ， 不存在返回0
     */
    public int isExistItem(ShopBook shopBook){
        return shopBookService.ifExistItem(shopBook);
    }

    /**
     * 更新重复添加至购物车的商品 数量
     * @param shopBook
     * @return 成功返回1
     */
    public int  updatenum(ShopBook shopBook){
        return shopBookService.updateMount(shopBook);
    }


}

