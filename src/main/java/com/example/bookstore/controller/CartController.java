package com.example.bookstore.controller;

import com.example.bookstore.entity.BookVO;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 删除用户购物车选定条目
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="deletecart",method = RequestMethod.POST)
    public @ResponseBody String deleteShopbook(HttpServletRequest request)  throws Exception{
        System.out.println("deletecart Controller-------------------------------------------");
        //获取json报文中的用户id和被选中的书本id集合
        int customerid = Integer.parseInt( request.getParameter("cusid") );
        String booknames = request.getParameter("linked");
        //打印显示
        System.out.println("deleteCart(用户id，选中书name)):"+customerid+","+booknames);
        //字符串处理
       booknames = booknames.replace("\"", "");
       //判断选择是否为空
        if(booknames.equals("")){
            return "noSelect" ;
        }
       String[] items = booknames.split(",");
       //Integer类型集合存储书本id
        List<Integer> intItems = new ArrayList<>();
       for(String s : items ){
           System.out.println(s);
           intItems.add(cartService.selectBookidByName(s));
       }
       //打印书本id集合
        System.out.println(intItems);
       //删除信息封装到shopbook对象中
        ShopBook shopBook = new ShopBook();
        shopBook.setCustomerid(customerid);
        //循环set/删除
        for (int i : intItems) {
            shopBook.setBookid(i);
            int flag = 0;
            flag = cartService.deleteShopbook(shopBook);
            if(flag == 0 ){
                System.out.println("CartController: 删除购物车记录"+customerid+","+i);
                continue;
            }
        }
        //返回标志字段
        return "ok";
        }

    /**
     * 获取登陆用户的购物车清单3
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
