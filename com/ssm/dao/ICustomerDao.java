package com.ssm.dao;

import com.ssm.bean.Customer;

/**
 * 用户信息bean
 * @author Administrator
 *
 */
public interface ICustomerDao {
	
	/**
	 * 添加新用户
	 * @param customer
	 */
	boolean addCustomer(Customer customer);
	
	/**
	 * 通过用户id查找
	 * @param id
	 * @return
	 */
	Customer findCustomerById(long id);
	
	/**
	 * 通过用户名查找
	 * @param name
	 * @return
	 */
	Customer findCustomerByName(String name);
	
	/**
	 * 更新用户信息
	 * @param id
	 */
	int updateCustomer(Customer customer);
}
