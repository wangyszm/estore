package com.ssm.web.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssm.bean.Customer;
import com.ssm.bean.Line;
import com.ssm.bean.Order;
/**
 * 当用户发生购物有关行为时，拦截检测是否创建购物车
 * @author Administrator
 *
 */
public class ShoprCartInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * 在请求到达handler前判断是否存在购物车
	 * 只是创建一个空的集合
	 * 等需要时再添加内容
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		HttpSession session=request.getSession();
		
		if(session.getAttribute("shopCart")==null){
			Customer customer=(Customer)session.getAttribute("customer");
			Order order=new Order();
			order.setCustomer(customer);
			//key值表示书id
			//value值表示相应购物记录
			session.setAttribute("shopCart", new HashMap<String,Line>());
			session.setAttribute("order",order);
		}
		return true;
	}
}
