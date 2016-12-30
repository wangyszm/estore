package com.test.aop.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 代理类
 * @author Administrator
 *
 */
public class ProxyClass implements InvocationHandler{
	private Object target;
	
	public ProxyClass() {}
	public ProxyClass(Object target){
		this.target=target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before call");
		method.invoke(target, args);
		System.out.println("after call");
		return null;
	}

}
