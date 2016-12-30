package com.ssm.dao;

import com.ssm.bean.Order;

public interface IOrderDao {
	
	/**
	 * 插入总订单
	 * @param order
	 * @return
	 */
	boolean insertOrder(Order order);
}
