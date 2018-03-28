package com.example.bookstore.controller;

import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.service.CustomerService;
import com.example.bookstore.service.ShopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
public class ShopBookController {
    @Autowired
    private ShopBookService shopBookService ;
    private CustomerService customerService ;

    @RequestMapping(value = "/addCart")
    public void addCart(HttpServletRequest request , HttpSession session, HttpServletResponse response) throws Exception{
        if(session.getAttribute("loginid")==null){
            response.sendRedirect("login");
        }else {
            ShopBook shopBook = new ShopBook();
            shopBook.setBookid(  Integer.parseInt( request.getParameter("bookid") ) );
            int cusid = Integer.parseInt(request.getParameter("cusid") );
            shopBook.setCustomerid(cusid);
            shopBook.setOrdermount( Integer.parseInt( request.getParameter("num") ));
            shopBook.setIspaid(request.getParameter("ispaid"));
            shopBook.setPrice( BigDecimal.valueOf(Double.parseDouble(request.getParameter("price") ) ) );

            int flag = shopBookService.addToCart(shopBook);
            System.out.println("Flag:(0为失败，1为成功)"+flag);

        }
    }
}

