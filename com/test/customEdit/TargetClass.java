package com.test.customEdit;

/**
 * 测试Spring自定义编辑器的注入
 * 该类为目标bean类
 * @author Administrator
 *
 */
public class TargetClass {
	private String hello;
	private String world;
	
	public String getHello() {
		return hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}
	public String getWorld() {
		return world;
	}
	public void setWorld(String world) {
		this.world = world;
	}

	@Override
	public String toString() {
		return "TargetClass [hello=" + hello + ", world=" + world + "]";
	}
}
