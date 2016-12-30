package com.test.customEvent;

import org.springframework.context.ApplicationEvent;
/**
 * 自定义事件类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CustomEvent extends ApplicationEvent{
	
	public CustomEvent(Object source) {
		super(source);
	}

}
