package com.test.aop.aspectJ.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 需要被代理的类
 * @author Administrator
 *
 */
@Component
public class TargetClass {
	
	public String targetDaoMethod(){
		System.out.println("this is targetDaoMethod");
		return "targetDaoMethod()";
	}
	
	public String targetDaoMethod(String str){
		System.out.println("this is targetDaoMethod with: "+str);
//		targetDaoMethod();
		return "targetDaoMethod(str)";
	}
}
