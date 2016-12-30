package com.briup.service;

import java.util.List;
import java.util.Map;

import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.Line;
import com.briup.bean.Order;

/**
 * 与订单项有关的service
 * @author Administrator
 *
 */
public interface ILineService {
	
	/**
	 * 添加订单项
	 */
	public void addLine(Line line,Order order,Book book);
	
	/**
	 * 获取用户的订单项
	 */
	public Map<Long,Line> findLine(Order order);
	
	/**
	 * 修改订单
	 */
	public boolean updateLine(Line line);
}
