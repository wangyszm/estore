package com.briup.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.briup.bean.Customer;
import com.briup.bean.Order;
import com.briup.common.Log4jFactory;
import com.briup.common.MapperFactory;
import com.briup.dao.IOrderDao;
import com.briup.service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	private IOrderDao mapper;
	private Logger logger;
	
	@Override
	public void addOrder(Order order, Customer customer) {
		mapper.addOrder(order,customer);
	}

	@Override
	public Order findOrder(Long id) {
		Order order=mapper.findOrderByCustomer(id);
		return order;
	}

	@Override
	public Order findOrderByCustomer(Customer customer) {
		String name = customer.getName();
		return findOrderByCustomer(name);
	}
	@Override
	public Order findOrderByCustomer(String userName) {
		Long cusId=CustomerServiceImpl.getInstance().getCustomer(userName, null).getId();
		Order order=mapper.findOrderByCustomer(cusId);
		if(order!=null){
			return order;
		}
		else{
			logger.error("没有相应订单");
			return null;
		}
	}

	public static OrderServiceImpl getInstance(){
		OrderServiceImpl orderService=new OrderServiceImpl();
		orderService.init();
		return orderService;
	}
	
	private void init(){
		mapper=MapperFactory.getSession(true).getMapper(IOrderDao.class);
		logger=Log4jFactory.getLogger();
	}

}
