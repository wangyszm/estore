package com.briup.dao;

import com.briup.bean.Customer;
import com.briup.bean.Order;

/**
 * 订单Dao层
 * @author Administrator
 *
 */
public interface IOrderDao {
	
	/**
	 * 添加订单
	 */
	void addOrder(Order order,Customer customer);

	/**
	 * 查询订单
	 */
	Order findOrderByCustomer(Long cusId);
	
	/**
	 * 更新订单
	 */
	void updateOrder(Order order);
}
