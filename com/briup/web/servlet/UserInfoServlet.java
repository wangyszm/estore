package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class UserinfoServlet
 */
@WebServlet("/custom/userInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String userName=(String)session.getAttribute("username");
		Customer customer=CustomerServiceImpl.getInstance().getCustomer(userName, null);
		String[] address=customer.getAddress().split(" ");
		String[] phone=customer.getTelephone().split(" ");
		
		request.setAttribute("customer", customer);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/userinfo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
