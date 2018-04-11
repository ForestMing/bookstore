package com.example.bookstore.controller;


import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.BookVO;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            //得到用户购物车信息
            List bookVOList = getCart(uid);
            //model中添加VO
            System.out.println(bookVOList);
            model.addAttribute("lists",bookVOList);
            return "cart";
        }else{
            return "redirect:login";
        }

    }

    @RequestMapping(value="deletecart",method = RequestMethod.POST)
    public ModelAndView deletecart(HttpServletRequest request) throws Exception{
        int customerid = Integer.parseInt(request.getParameter("cusid") );
        int bookid = Integer.parseInt( request.getParameter("bookid") );
        System.out.println("deleteCart"+customerid+","+bookid);
        ShopBook shopBook = new ShopBook();
        shopBook.setCustomerid(customerid);
        shopBook.setBookid(bookid);
        int flag = 0 ;
        flag = cartService.deleteShopbook(shopBook);
        System.out.println("CartController: 删除购物车记录 1 成功:"+flag);
        ModelAndView modelAndView = new ModelAndView("flashCart");
        List bookVOList = getCart(customerid);
        modelAndView.addObject("lists",bookVOList);
        return modelAndView;
    }

    /**
     * 获取登陆用户的购物车清单
     * @param uid
     * @return
     */
    public List getCart(int uid){
        //获取用户购物车清单
        List<ShopBook> carts = cartService.selectShopBooksByCusid(uid);
        System.out.println(carts);
        //封装到BookVO对象中用于前台展示
        List<BookVO> bookVOList = new ArrayList<BookVO>();
        for( ShopBook s : carts ){
            BookVO bookVO = new BookVO();
            bookVO.setBookid(s.getBookid());
            bookVO.setBookname(cartService.selectBookNameById(s.getBookid()));
            bookVO.setBookpic(cartService.selectBookPicById(s.getBookid()));
            bookVO.setMount(s.getOrdermount());
            bookVO.setBookprprice(s.getPrice());
            bookVOList.add(bookVO);
        }
        return bookVOList;
    }
}
