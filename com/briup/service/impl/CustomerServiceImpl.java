package com.briup.service.impl;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.briup.bean.Customer;
import com.briup.common.Log4jFactory;
import com.briup.common.MapperFactory;
import com.briup.dao.ICustomerDao;
import com.briup.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	private ICustomerDao mapper;
	private Logger logger;
	
	@Override
	public void addCustomer(Customer customer) {
		if(customer!=null){
			String name=customer.getName();
			System.out.println(name);
			if(mapper.findCustomerByName(name)!=null){
				if(!name.equals(mapper.findCustomerByName(name).getName())){
					logger.info("插入成功");
					mapper.addCustomer(customer);
				}
				else{
					logger.error("用户名重复");
				}
			}
			else{
				logger.info("插入成功");
				mapper.addCustomer(customer);
			}
		}
		else{
			logger.error("需要有效数据");
		}
	}

	@Override
	public boolean loginCustomer(String name, String password) {
		Customer customer=mapper.findCustomerByName(name);
		if(customer!=null){
			if(customer.getPassword().equals(password)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
			mapper.updateCustomer(customer);
			logger.info("修改成功");
	}

	@Override
	public Customer getCustomer(String name,String id) {
		Customer customer=null;
		if(name==null){
			customer=mapper.findCustomerById(new Long(id));
			return customer;
		}
		else{
			customer=mapper.findCustomerByName(name);
			return customer;
		}
	}
	
	public static CustomerServiceImpl getInstance(){
		CustomerServiceImpl customerService=new CustomerServiceImpl();
		customerService.init();
		return customerService;
	}
	
	private void init(){
		mapper=MapperFactory.getSession(true).getMapper(ICustomerDao.class);
		logger=Log4jFactory.getLogger();
	}

/*	@Test
	public void test(){
		mapper=MapperFactory.getSession(true).getMapper(ICustomerDao.class);
		Customer customer=mapper.findCustomerByName("hasd");
		System.out.println(customer);
	}*/
	
}
