package com.test.customEvent;

import org.springframework.context.ApplicationListener;

public class EventListener implements ApplicationListener<CustomEvent>{
	
	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println(event.getSource());
	}
}

//可采用如下方式，即不声明泛型，此时须在实现的方法中加入判断，适合多事件存在的情况
/*@SuppressWarnings("rawtypes")
public class EventListener implements ApplicationListener{
	
	//如果对ApplicationListener不声明泛型时，实现的是如下方法
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof CustomEvent){
			System.out.println("this from customListener");
		}
	}
}*/