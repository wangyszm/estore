package com.test.aop.cglib;

/**
 * 委托类，利用CGLib不需要委托类实现接口
 * 采用字节码技术动态生成委托类的子类
 * 子类会拦截父类方法的调用
 * 并加入逻辑
 * @author Administrator
 *
 */
public class TargetClass {
	public void call(){
		System.out.println("targetClass call");
	}
}
