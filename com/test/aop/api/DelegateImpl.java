package com.test.aop.api;

/**
 * 委托类具体实现
 * @author Administrator
 *
 */
public class DelegateImpl implements IDelegate{

	@Override
	public void call() {
		System.out.println("Delegate call");
	}
	
}
