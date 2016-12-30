package com.test.aop.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 代理类
 * @author Administrator
 *
 */
public class ProxyClass implements MethodInterceptor{
	
	public Object getProxy(Class<?> cls){
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	//在该方法中加入代理的部分
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("target before");
		System.out.println("this: "+this.getClass());
		System.out.println("super: "+this.getClass().getSuperclass());
		//调用父类中的方法
		arg3.invokeSuper(arg0, arg2);
		System.out.println("target after");
		return null;
	}
	
}
