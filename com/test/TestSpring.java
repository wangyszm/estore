package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.aop.aspectJ.dao.TargetClass;
import com.test.customEdit.ClientClass;
import com.test.customEvent.CustomEvent;
import com.test.factoryBean.NoParameterConstructor;

/**
 * 测试Spring用方法
 * @author Administrator
 *
 */
public class TestSpring {
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		String[] path={"com/test/factoryBean/spring-factory.xml",
				"com/test/customEdit/customEdit.xml",
				"com/test/customEvent/customEvent.xml",
				"com/test/aop/aspectJ/@AspectJ.xml"};
		ApplicationContext container=new ClassPathXmlApplicationContext(path);
		
		//测试aop相关
		TargetClass target=(TargetClass)container.getBean("targetClass");
		target.targetDaoMethod("hello");
		
/*		//测试自定义事件
		container.publishEvent(new CustomEvent("this from customListener"));*/
		
/*		//测试自定义编辑器
		ClientClass client = (ClientClass) container.getBean("client");
		System.out.println(client);*/
		
/*		//测试实例工厂
//		String str=(String) container.getBean("staticFac");
//		String str=(String) container.getBean("extendFac");
//		String str=(String) container.getBean("instanceFac");
		
		NoParameterConstructor noParam=(NoParameterConstructor) container.getBean("noParameter");
		String str = noParam.getStr();
		System.out.println(str);*/
	}
}
