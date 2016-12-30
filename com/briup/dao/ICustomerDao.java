package com.briup.dao;

import com.briup.bean.Customer;

/**
 * 用户Dao层
 * @author Administrator
 *
 */
public interface ICustomerDao {

	/**
	 * 添加用户
	 */
	void addCustomer(Customer customer);
	
	/**
	 * 通过id查询用户
	 */
	Customer findCustomerById(Long id);
	
	/**
	 * 通过姓名查询用户
	 */
	Customer findCustomerByName(String name);
	
	/**
	 * 修改用户
	 */
	void updateCustomer(Customer customer);
	
	/**
	 * 删除用户
	 */
	void deleteCustomer(Long id);
	
}
