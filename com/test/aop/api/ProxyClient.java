package com.test.aop.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 实现委托-代理模式
 * @author Administrator
 *
 */
public class ProxyClient {
	public static void main(String[] args) {
		IDelegate target=new DelegateImpl();
		
		//获取目标类的运行时Class对象
		Class<?> cls=target.getClass();
		//获取目标类的类加载器
		ClassLoader classLoader=cls.getClassLoader();
		//获取目标类实现的接口列表
		Class<?>[] interfaces=cls.getInterfaces();
		//获取InvocationHandler的具体实现类（代理类），并传入委托类
		InvocationHandler handler=new ProxyClass(target);
		
		IDelegate proxy=(IDelegate) Proxy.newProxyInstance(classLoader,interfaces,handler);
		proxy.call();
	}
}
