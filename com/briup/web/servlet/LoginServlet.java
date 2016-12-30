package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/custom/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=null;
		
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		
		boolean flag=CustomerServiceImpl.getInstance().loginCustomer(userName, passWord);
		
		
		if(flag==true){
			HttpSession session=request.getSession();
			session.setAttribute("username", userName);
			request.setAttribute("msg", "login success");
			dispatcher = request.getRequestDispatcher("index");
		}
		else{
			request.setAttribute("msg", "login failed");
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
