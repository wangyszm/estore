package com.briup.dao;

import java.util.List;

import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.Line;
import com.briup.bean.Order;

/**
 * 订单项的Dao层
 * @author Administrator
 *
 */
public interface ILineDao {
	
	/**
	 * 添加订单项
	 */
	void addLine(Line line,Order order,Book book);
	
	/**
	 * 获取用户的订单项
	 */
	List<Line> findLineByOrder(Long orderId);
	
	/**
	 * 修改订单项
	 */
	void updateLine(Line line);
	
	/**
	 * LineMapper内方法
	 */
	Order findOrderById(Long id);
	
	/**
	 * LineMapper内方法
	 */
	Book findBookById(Long id);
	
	/**
	 * LineMapper内方法
	 */
	Customer findCustomerById(Long id);
}
