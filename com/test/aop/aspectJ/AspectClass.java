package com.test.aop.aspectJ;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 用作SpringAOP中Aspect的类
 * 捕捉通用的切入点表达式
 * 实现Ordered(org.springframework.core)可以使得通知按优先级(getOrder)执行
 * 较低值的有较高的优先级
 * @author Administrator
 *
 */
@Aspect
@Configurable("commonAspect")
public class AspectClass implements Ordered{
	
//	@Pointcut("within(com.test.aop.aspectJ.dao..*)")
	@Pointcut("execution(* com.test.aop.aspectJ.dao..*.*())")
	private void anyPulbicOperation(){}
	
//	@Pointcut("within(com.test.aop.aspectJ.dao..*)")
	@Pointcut("execution(* com.test.aop.aspectJ.dao..*.*(..)) &&"+
			"args(str)")
	private void anyPulbicOperationWithParam(String str){}
	
	
	@Before(value="com.test.aop.aspectJ.AspectClass.anyPulbicOperation()")
	public void beforeAdvice(){
		System.out.println("this is beforeAdvice");
	}
	
	@Before(value="com.test.aop.aspectJ.AspectClass.anyPulbicOperationWithParam(str)")
	public void beforeAdvice(String str){
		System.out.println("this is beforeAdvice,maybe with "+str);
	}
	
//	@AfterReturning("execution(* com.test.aop.aspectJ.dao..*.*(..))")
	@AfterReturning(pointcut="com.test.aop.aspectJ.AspectClass.anyPulbicOperation()",
			returning="str")
	public void retAdvice(String str){
		System.out.println("this is afterAdvice...from "+str);
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
}
