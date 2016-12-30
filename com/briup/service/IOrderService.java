package com.briup.service;

import java.util.List;

import com.briup.bean.Customer;
import com.briup.bean.Order;

/**
 * 与订单有关的Service
 * @author Administrator
 *
 */
public interface IOrderService {
	
	/**
	 * 创建订单
	 */
	public void addOrder(Order order,Customer customer);
	
	/**
	 * 查询某条订单
	 */
	public Order findOrder(Long id);
	
	/**
	 * 查询顾客(Customer)的订单
	 */
	public Order findOrderByCustomer(Customer customer);
	
	public Order findOrderByCustomer(String userName);
}
