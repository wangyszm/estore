package com.briup.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.Line;
import com.briup.bean.Order;
import com.briup.common.Log4jFactory;
import com.briup.common.MapperFactory;
import com.briup.dao.ICustomerDao;
import com.briup.dao.ILineDao;
import com.briup.dao.IOrderDao;
import com.briup.service.ILineService;

public class LineServiceImpl implements ILineService{
	private ILineDao mapper;
	private Logger logger;

	@Override
	public void addLine(Line line,Order order, Book book) {
		if(book!=null && order!=null){
			System.out.println(order);
			System.out.println(book);
			if(book.getId()!=null && order.getId()!=null){
				
				mapper.addLine(line,order ,book);
				logger.info("插入成功");
			}
			else{
				logger.error("非法id");
			}
		}
		else{
			logger.error("引用不能为空");
		}
	}

	@Override
	public Map<Long,Line> findLine(Order order) {
		if(order!=null){
			if(order.getId()!=null){
				Map<Long,Line> lines = MapperFactory.getSession(true)
						.selectMap("com.briup.dao.ILineDao.findLineByOrder",order,"book.id");
				return lines;
			}
		}
			return null;
	}

	@Override
	public boolean updateLine(Line line) {
		if(line!=null){
			if(line.getId()>0){
				mapper.updateLine(line);
				return true;
			}
			else{
				return false;
			}
		}
		else{
			logger.info("引用不能为空");
			return false;
		}
	}
	
	public static LineServiceImpl getInstance(){
		LineServiceImpl lineService=new LineServiceImpl();
		lineService.init();
		return lineService;
	}
	
	private void init(){
		mapper=MapperFactory.getSession(true).getMapper(ILineDao.class);
		logger=Log4jFactory.getLogger();
	}
	
	@Test
	public void test(){
		ICustomerDao cusMapper=MapperFactory.getSession(true).getMapper(ICustomerDao.class);
		IOrderDao ordMapper=MapperFactory.getSession(true).getMapper(IOrderDao.class);
		
		Customer cus = cusMapper.findCustomerById(2l);
		Order order=ordMapper.findOrderByCustomer(cus.getId());
		
		Map<Long,Line> map=MapperFactory.getSession(true).selectMap("com.briup.dao.ILineDao.findLineByOrder",order,"book.id");
		
		System.out.println(map);
	}

}
