package com.ssm.web.handler.authority;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.bean.Book;
import com.ssm.bean.Customer;
import com.ssm.bean.Line;
import com.ssm.bean.Order;
import com.ssm.common.ContainerFactory;
import com.ssm.dao.ICustomerDao;
import com.ssm.service.ShoppingService;

/**
 * 当用户触发购物相关行为时，调用此handler下的方法
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
@RequestMapping("/authority")
@Controller
public class Shopping {

	/**
	 * 当用户加入商品至购物车时，调用此handler
	 */
	@RequestMapping(value="/shopping",method=RequestMethod.GET)
	public String shopping(@RequestParam("id") String bookId,HttpServletRequest request,HttpSession session){
		ApplicationContext container=ContainerFactory.getInstance().getContainer();
		ShoppingService shoppingService=(ShoppingService) container.getBean("shoppingService");
		
		ServletContext application=request.getServletContext();
		Map<Long,Book> books=(Map<Long, Book>) application.getAttribute("books");
		Map<String,Line> shopCart=(Map<String, Line>) session.getAttribute("shopCart");
		Order order=(Order)session.getAttribute("order");
		
		shoppingService.addGoods(bookId, books, shopCart,order);
		return "index";
	}
	
	/**
	 * 当用户请求购物车页面时，调用此handler
	 */
	@RequestMapping(value="/shopcart",method=RequestMethod.GET)
	public String linkToShopCartPage(){
		return "shopcart";
	}
	
	@RequestMapping(value="/updateLine",method=RequestMethod.POST)
	public void updateLine(@RequestParam("productid") String bookId,String number,
			HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Line> shopCart = (Map<String, Line>) session.getAttribute("shopCart");
		shopCart.get(bookId).setNum(Integer.parseInt(number));
		response.sendRedirect(request.getContextPath()+"/authority/shopcart");
	}
	
	/**
	 * 当用户触发移除所有订单操作时，调用此handler
	 */
	@RequestMapping("/removeAll")
	public String removeAllProduct(HttpSession session){
		Map<String,Line> shopCart=(Map<String, Line>) session.getAttribute("shopCart");
		shopCart.clear();
		
		return "shopcart";
	}
	
	/**
	 * 当用户提交订单时，调用此handler
	 * 需要将shopCart中的数据存入数据库
	 */
	@RequestMapping("/submitOrder")
	public String submitOrder(String total,HttpSession session){
		ApplicationContext container=ContainerFactory.getInstance().getContainer();
		ShoppingService shoppingService=(ShoppingService) container.getBean("shoppingService");
		
		Map<String,Line> shopCart=(Map<String, Line>) session.getAttribute("shopCart");
		Customer customer=(Customer) session.getAttribute("customer");
		Order order=(Order) session.getAttribute("order");
		
		shoppingService.addLines(new Double(total).doubleValue(), shopCart, customer, order);
		return "index";
	}
}