package com.ssm.dao;

import java.util.List;

import com.ssm.bean.Line;

/**
 * 有关Line的数据层
 * @author Administrator
 *
 */
public interface ILineDao {
	
	/**
	 * 添加订单
	 * @return
	 */
	boolean addLine(List<Line> line);
}
