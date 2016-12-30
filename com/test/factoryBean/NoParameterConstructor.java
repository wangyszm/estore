package com.test.factoryBean;

/**
 * 通过无参构造器直接获取实例
 * @author Administrator
 *
 */
public class NoParameterConstructor {
	private String str="this is empty-arguments";
	
	public NoParameterConstructor() {}
	
	public String getStr(){
		return str;
	}
}
