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

    /**
     * 添加商品至购物车
     * @param shopBook
     * @param session
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addCart" ,method = RequestMethod.POST)
    public @ResponseBody String add(@RequestBody ShopBook shopBook, HttpSession session , HttpServletResponse response)
            throws Exception
    {
        System.out.println("addCart Controller --------------------------------------------------");
        if (session.getAttribute("loginid") == null) {
            System.out.println("ShopBookController:loginid == null ");
            //response.sendRedirect("login");
            return "noLogin";
        }else {
            System.out.println("ShopBookController:loginid != null ");
            System.out.println(shopBook);
            //判断加入数量是否超过库存
            int totalmount = shopBookService.selectBookStoremountById(shopBook.getBookid());
            System.out.println("-------该书本总库存："+totalmount);
            if(totalmount < shopBook.getOrdermount()){
                return "overMaxMount" ;
            }
            //判断是否已存在对于购物车条目
            int isAdded = isExistItem(shopBook);
            if(isAdded == 1 ){
               int updatesinfo =  updatenum(shopBook) ;
               return "changeMountSuccess";
            }else {
                int flag = shopBookService.addToCart(shopBook);
                System.out.println("Flag:(1为成功)" + flag);
                return "addCartSuccess";
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

