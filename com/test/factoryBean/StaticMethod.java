package com.test.factoryBean;

/**
 * 测试Spring容器中的bean工厂模式
 * 利用静态属性与方法直接获取（实例）
 * @author Administrator
 *
 */
public class StaticMethod {
	private static String str="this is staticFactory";
	
	/**
	 * 利用静态方法
	 * @return
	 */
	public static String getStr(){
		return str;
	}
	
	
}
