package com.test.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 利用实现给定接口的方式
 * 重写接口方法直接获得
 * 这里用String只是简单展示一下
 * 一般可用在获取数据库链接对象上等
 * @author Administrator
 *
 */
public class ExtendImpl implements FactoryBean<String>{
	private String str="this is extendFactory";

	/**
	 * Spring通过此方法自动得到值
	 * 因此在配置时无需声明factory相关属性
	 */
	@Override
	public String getObject() throws Exception {
		return str;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
