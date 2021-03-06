package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/custom/user/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer=doInfo(request);
		
		if(customer==null){
			response.sendRedirect("userinfo.jsp");
		}
		else{
			CustomerServiceImpl.getInstance().updateCustomer(customer);
			response.sendRedirect("../index");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private Customer doInfo(HttpServletRequest request){
		String passWord=request.getParameter("password");
		String passWord_repeat=request.getParameter("password_repeat");
		String country=request.getParameter("country");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String street1=request.getParameter("street1");
		String street2=request.getParameter("street2");
		String zip=request.getParameter("zip");
		String homePhone=request.getParameter("homephone");
		String officePhone=request.getParameter("officephone");
		String cellPhone=request.getParameter("cellphone");
		String email=request.getParameter("email");
		
		if(passWord.equals(passWord_repeat)){
			HttpSession session=request.getSession();
			String userName=(String)session.getAttribute("username");
			Customer customer=new Customer(userName,passWord,zip,
						country+" "+province+" "+city+" "+street1+" "+street2,
						homePhone+" "+officePhone+" "+cellPhone,email);
			return customer;
		}
		else{
			return null;
		}
	}
}
