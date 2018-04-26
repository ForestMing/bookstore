package com.example.bookstore.controller;

import com.example.bookstore.entity.BookVO;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.entity.Order;
import com.example.bookstore.entity.ShopBook;
import com.example.bookstore.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
     * 修改购物车单条商品的添加量
     */
    @RequestMapping(value="/chngNum",method = RequestMethod.POST)
    public @ResponseBody String changeCount(@RequestBody ShopBook shopBook)  throws Exception
    {
        System.out.println("``````````chngNum Controller :修改数量后的shopbook"+shopBook);
        int flag = 0 ;
        flag = cartService.updateCartMount(shopBook);
        System.out.println("----------chngNum flag (1) 为成功 :" + flag);
        if(flag == 1 ) {
            return "changeSuccess";
        }else{
            return "changeFail";
        }

    }

    /**
     * 购物车选定商品结算，生成订单
     */
    @RequestMapping(value="createOrder",method = RequestMethod.POST)
    public @ResponseBody  String makeOrder(HttpServletRequest request,Model model )  throws Exception{
        System.out.println("createOrder Controller-------------------------------------------");
        //获取json报文中的用户id和被选中的书本id集合
        int customerid = Integer.parseInt( request.getParameter("cusid") );
        String booknames = request.getParameter("linked");
        String orderinfo = request.getParameter("orderRecive") ;

        //打印显示
        System.out.println("createOrder(用户id，选中书name)):"+customerid+","+booknames);

        //书本条目字符串处理
        booknames = booknames.replace("\"", "");
        String[] items = booknames.split(",");

        //订单联系信息字符串处理
        orderinfo = orderinfo.replace("\"","");
        String[] orderinfoArray = orderinfo.split(",");
        System.out.println("订单联系人信息："+orderinfo);

        //Integer类型集合存储书本id
        List<Integer> intItems = new ArrayList<>();
        for(String s : items ){
            System.out.println(s);
            intItems.add(cartService.selectBookidByName(s));
        }

        //打印书本id集合
        System.out.println(intItems);
        //结算的信息封装到shopbook对象集合dealList中
        List<ShopBook> dealList = new ArrayList<>();
        for (int i : intItems) {
            ShopBook shopBook = new ShopBook();
            shopBook.setCustomerid(customerid);
            shopBook.setBookid(i);
            //获取shopbook的cusid和bookid在数据库中获取完整记录
            shopBook = cartService.selectShopbookByCusidAndBookid(shopBook);
            //添加到结算列表中
            dealList.add(shopBook) ;
        }
        System.out.println("-----------结算的书本："+dealList);

        //订单对象集合
        List<Order> orders = new ArrayList<>();

        //把dealList集合中的shopbook对象补全信息，封装成order对象
        for(ShopBook shopBook : dealList){
            Order order = new Order();
            order.setRecevername(orderinfoArray[0]);
            order.setRecevertel(orderinfoArray[1]);
            order.setReceveraddr(orderinfoArray[2]);
            order.setMessage(orderinfoArray[3]);
            order.setPaymethod(orderinfoArray[4]);
            //获取和计算shopbook中的信息
            order.setCustomerid(shopBook.getCustomerid());
            order.setOrdermount(shopBook.getOrdermount());
            order.setTotalprice(shopBook.getOrdermount()*shopBook.getPrice());
            //生成订单号 orderid = {booid}#{ordermount}#{当前时间}#{cusid}
            order.setOrderid(shopBook.getBookid()+"#"+shopBook.getOrdermount()
                    +"#"+getCurrtTime()+"#"+shopBook.getCustomerid());

            orders.add(order);
        }

        System.out.println(orders);


        // 再对数据库中shopbook表记录删除，order表记录添加


        //返回成功标志字段
        return "makeSuccess" ;
    }

    /**
     * 获取当前系统时间
     */
    public String getCurrtTime(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));
        return df.format(day);
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
