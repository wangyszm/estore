package com.test.aop.cglib;


/**
 * 测试CGLib动态代理
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		ProxyClass proxy=new ProxyClass();
		TargetClass target=(TargetClass)proxy.getProxy(TargetClass.class);
		target.call();
	}
}
