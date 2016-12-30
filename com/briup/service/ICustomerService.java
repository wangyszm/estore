package com.briup.service;

import com.briup.bean.Customer;

/**
 * 与用户数据有关的service层
 * @author Administrator
 *
 */
public interface ICustomerService {
	
	/**
	 * 用户注册
	 */
	public void addCustomer(Customer customer);
	
	/**
	 * 用户登录
	 */
	public boolean loginCustomer(String name,String password);
	
	/**
	 * 更新用户信息
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * 查询用户信息
	 * 两个参数中必须有一个为null
	 */
	public Customer getCustomer(String name,String id);
}
