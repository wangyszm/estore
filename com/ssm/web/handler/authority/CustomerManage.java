package com.ssm.web.handler.authority;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.bean.Customer;
import com.ssm.common.ContainerFactory;
import com.ssm.service.CustomerService;

/**
 * 用户管理页面
 * 修改个人信息
 * @author Administrator
 *
 */
@RequestMapping("/authority")
@Controller
@Lazy
public class CustomerManage {

	/**
	 * 进入修改个人信息页面时，调用该handler
	 */
	@RequestMapping(value="/userInfo",method=RequestMethod.GET)
	public ModelAndView userInfo(ModelAndView mv,HttpSession session){
		Customer customer=(Customer) session.getAttribute("customer");
		
		mv.setViewName("user/userinfo");
		mv.addObject("address", customer.getAddress().split(","));
		return mv;
	}
	
	/**
	 * 提交修改个人信息的表单时，调用此handler
	 */
	@RequestMapping(value="/modify",consumes="application/json",produces="application/text;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String userInfo(@RequestBody Customer customer){
		ApplicationContext container = ContainerFactory.getInstance().getContainer();
		CustomerService customerService=(CustomerService) container.getBean("customerService");
		System.out.println(customer);
		int flag = customerService.updateCustomer(customer);
		if(flag==1){
			//在这里插入事务提交
			return "1";
		}
		else{
			//在这里插入事务回滚
			return "0";
		}
	}
}
