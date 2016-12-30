package com.test.customEdit;

/**
 * 测试Spring自定义编辑器的注入
 * 同时测试Spring的IOC注入
 * 该类包含一个目标类TargetClass
 * 需要将传入目标类的字符串转换为目标类中的属性
 * @author Administrator
 *
 */
public class ClientClass {
	private String str;
	private TargetClass targetClass;
	
	
	public ClientClass() {}
	public ClientClass(String str, TargetClass targetClass) {
		this.str = str;
		this.targetClass = targetClass;
	}

	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public TargetClass getTargetClass() {
		return targetClass;
	}
	public void setTargetClass(TargetClass targetClass) {
		this.targetClass = targetClass;
	}
	
	@Override
	public String toString() {
		return "ClientClass [str=" + str + ", targetClass=" + targetClass + "]";
	}
	
}
