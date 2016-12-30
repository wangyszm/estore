package com.ssm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.bean.Customer;
import com.ssm.common.ContainerFactory;
import com.ssm.dao.ICustomerDao;

/**
 * 用户服务层
 * @author Administrator
 *
 */
@Service("customerService")
@Lazy
public class CustomerService {
	private ICustomerDao customerDao;
	
	public CustomerService() {
		init();
	}
	
	/**
	 * 新用户注册
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(Customer customer){
		return customerDao.addCustomer(customer);
	}
	
	/**
	 * 用户登录时调用该方法
	 * 匹配用户名、密码与数据库中的值
	 * @param name
	 * @return
	 */
	/*public ModelAndView customerLogin(String name,String password){
		Customer customer=customerDao.findCustomerByName(name.trim());
		
		ModelAndView mv=new ModelAndView();
		
		if(customer!=null && customer.getPassword().equals(password)){
			mv.setViewName("redirect:/index");
			mv.addObject("customer", customer);
			return mv;
		}
		mv.setViewName("login");
		return mv;
	}*/
	public ModelAndView customerLogin(String name,String password){
		Customer customer=customerDao.findCustomerByName(name.trim());
		
		ModelAndView mv=new ModelAndView();
		
		if(customer!=null && customer.getPassword().equals(password)){
			mv.setViewName("redirect:/index?");
			mv.addObject("customer", customer);
			
			return mv;
		}
		mv.setViewName("login");
		return mv;
	}
	
	/**
	 * 用户修改信息
	 * @param id
	 * @return 返回修改的条数
	 */
	public int updateCustomer(Customer customer){
		return customerDao.updateCustomer(customer);
	}
	
	private void init(){
		ApplicationContext container = ContainerFactory.getInstance().getContainer();
		customerDao=(ICustomerDao)container.getBean("ICustomerDao");
	}
}
