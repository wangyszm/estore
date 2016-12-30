package com.ssm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ssm.bean.Book;
import com.ssm.bean.Customer;
import com.ssm.bean.Line;
import com.ssm.common.ContainerFactory;
import com.ssm.dao.ILineDao;
import com.ssm.dao.IOrderDao;
import com.ssm.bean.Order;

/**
 * 用户购物行为中间层
 * @author Administrator
 *
 */
@Service("shoppingService")
@Lazy
public class ShoppingService {
//	private ICustomerDao customerDao;
	
//	public ShoppingService() {
//		init();
//	}
	
	/**
	 * 
	 * @param bookId 用户选择的书的id
	 * @param books application中所有的书的集合，key是书的id
	 * @param shopCart 购物车中用户订单的集合，key是与订单相关的书的id
	 */
	public void addGoods(String bookId,Map<Long,Book> books,Map<String,Line> shopCart,Order order){
		//判断有没有相关书的订单
		//没有的话添加并设置数量为1，有的话数量+1
		Long id=new Long(bookId);
		Line line=shopCart.get(bookId);
		if(line==null){
			line=new Line();
			line.setBook(books.get(id));
			line.setNum(1);
			line.setOrder(order);
			shopCart.put(bookId, line);
		}
		else{
			line.setNum(line.getNum()+1);
		}
	}
	
	/**
	 * 用户提交订单的service层
	 * 需要生成Order项
	 * @param total
	 * @param shopCart
	 * @param customer
	 */
	public void addLines(double total,Map<String,Line> shopCart,Customer customer,Order order){
		ApplicationContext container = ContainerFactory.getInstance().getContainer();
		ILineDao lineDao=(ILineDao)container.getBean("ILineDao");
		IOrderDao orderDao=(IOrderDao)container.getBean("IOrderDao");
		
		order.setCost(total);
		order.setOrderDate(new Date());
		
		orderDao.insertOrder(order);
		
		Collection<Line> coll = shopCart.values();
		lineDao.addLine(new ArrayList<Line>(coll));
		
	}
	
//	private void init(){
//		ApplicationContext container = ContainerFactory.getInstance().getContainer();
//		customerDao=(ICustomerDao)container.getBean("ICustomerDao");
//	}
}
