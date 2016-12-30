package com.ssm.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 将dao层、service层以及web层的xml配置文件注册在ApplicationContext中
 * 若想从IOC容器中获取bean时使用
 * @author Administrator
 *
 */
public class ContainerFactory {
	private static ContainerFactory factory=new ContainerFactory();
	private ApplicationContext container;
	
	private ContainerFactory(){
		init();
	}
	
	public static ContainerFactory getInstance(){
		if(factory==null){
			factory=new ContainerFactory();
		}
		return factory;
	}
	
	private void init(){
		String[] path=
			{"com/ssm/dao/spring-dao-config.xml",
				"com/ssm/service/spring-service-config.xml",
				"com/ssm/web/spring-web-config.xml"};
		container=new ClassPathXmlApplicationContext(path);
	}
	
	public ApplicationContext getContainer(){
		return container;
	}
}
