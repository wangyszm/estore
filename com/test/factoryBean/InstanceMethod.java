package com.test.factoryBean;

/**
 * 将该类注册为Spring的bean
 * 并通过另一个id设置属性factory-bean来标记该类为工厂bean
 * @author Administrator
 *
 */
public class InstanceMethod {
	private String str="this is InstanceFactory";

	public String getStr(){
		return str;
	}
}
