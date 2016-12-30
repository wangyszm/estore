package com.test;

/**
 * 测试Spring中的bean注入
 * @author Administrator
 *
 */
public class InjectBean {
	private String str;
	private int i;
	private boolean flag;
	
	public InjectBean() {}
	/**
	 * 利用构造器注入
	 * @param str
	 * @param i
	 * @param flag
	 */
	public InjectBean(String str, int i, boolean flag) {
		this.str = str;
		this.i = i;
		this.flag = flag;
	}
	
	
}
