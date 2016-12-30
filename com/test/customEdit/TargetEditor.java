package com.test.customEdit;

import java.beans.PropertyEditorSupport;

/**
 * 通过继承java.beans.PropertyEditorSupport类
 * 重写getAsText()与setAsText()
 * 利用setAsText处理传入的字符串
 * @author Administrator
 *
 */
public class TargetEditor extends PropertyEditorSupport{
	@Override
	public String getAsText() {
		return super.getAsText();
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] str=text.split(" ");
		TargetClass tar=new TargetClass();
		tar.setHello(str[0]);
		tar.setWorld(str[1]);
		setValue(tar);
	}
}
