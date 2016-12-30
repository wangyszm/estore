package com.ssm.web.handler.nopermission;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.bean.Customer;
import com.ssm.common.ContainerFactory;
import com.ssm.service.CustomerService;
/**
 * 登录与注册的handler
 * @author Administrator
 *
 */
@Controller
public class LoginAndRegister {
	
	/**
	 * 从登录页面请求登录时，调用该handler
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam String username,@RequestParam String password,HttpSession session){
		ApplicationContext container = ContainerFactory.getInstance().getContainer();
		CustomerService customerService=(CustomerService) container.getBean("customerService");
		
		ModelAndView mv=customerService.customerLogin(username, password);
		session.setAttribute("customer", mv.getModelMap().get("customer"));
		return mv;
	}
	
	/*@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam String username,@RequestParam String password,HttpSession session){
		ApplicationContext container = ContainerFactory.getInstance().getContainer();
		CustomerService customerService=(CustomerService) container.getBean("customerService");
		
		ModelAndView mv=customerService.customerLogin(username, password);
		session.setAttribute("customer", mv.getModelMap().get("customer"));
		return mv;
	}*/
	/**
	 * 如果没有登录或请求登录页面，就调用该handler
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginRequest(){
		return "login";
	}
	
	/**
	 * 跳转到register页面时，调用此handler
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String linkToRegister() throws Exception{
		return "register";
	}
	
	/**
	 * 提交注册页面信息时，调用此handler
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value="/register",consumes="application/json",produces="application/text;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String addRegisterInfo(@RequestBody Customer customer) throws Exception{
		ApplicationContext container = ContainerFactory.getInstance().getContainer();
		CustomerService customerService=(CustomerService) container.getBean("customerService");
		
		boolean flag = customerService.addCustomer(customer);
		if(flag==true){
			//在这里插入事务提交
			return "1";
		}
		else{
			//在这里插入事务回滚
			return "0";
		}
	}
}
