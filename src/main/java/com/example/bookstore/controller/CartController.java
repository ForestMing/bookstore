package com.example.bookstore.controller;


import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.BookVO;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService ;

    //载入主页
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(Model model, HttpSession session) {
        if (session.getAttribute("loginid") != null) {
            String name = (String) session.getAttribute("loginname");
            int uid = (Integer) session.getAttribute("loginid");
            System.out.println("cart收到login用户：" + name);
            System.out.println("cart收到login用户id：" + uid);
            //封装到cus对象
            Customer cus = new Customer();
            cus.setCustomerid(uid);
            cus.setCustomername(name);
            //封装到customer对象中用于前台展示
            model.addAttribute("currentCus",cus);
            //获取用户购物车清单
            List<ShopBook> carts = cartService.selectShopBooksByCusid(uid);
            System.out.println(carts);
            //封装到BookVO对象中用于前台展示
            List<BookVO> bookVOList = new ArrayList<BookVO>();
            BookVO bookVO = new BookVO();
            for( ShopBook s : carts ){
                bookVO.setBookid(s.getBookid());
                bookVO.setBookname(cartService.selectBookNameById(s.getBookid()));
                bookVO.setBookpic(cartService.selectBookPicById(s.getBookid()));
                bookVO.setMount(s.getOrdermount());
                bookVOList.add(bookVO);
            }
            //model中添加VO
            System.out.println(bookVOList);
            model.addAttribute("lists",bookVOList);
            return "cart";
        }else{
            return "redirect:login";
        }

    }

}
