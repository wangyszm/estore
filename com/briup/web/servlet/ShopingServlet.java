package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.Customer;
import com.briup.bean.Line;
import com.briup.bean.Order;
import com.briup.service.impl.BookServiceImpl;
import com.briup.service.impl.CustomerServiceImpl;
import com.briup.service.impl.LineServiceImpl;
import com.briup.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class ShopingServlet
 */
@WebServlet("/custom/shopping")
public class ShopingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String bookId=request.getParameter("id");
		Long key=new Long(bookId);
		
		Order order=(Order) session.getAttribute("order");
		Map<Long,Line> oldLines=(Map<Long, Line>) session.getAttribute("oldLines");
		Map<Long,Line> newLines=(Map<Long, Line>) session.getAttribute("newLines");
		
		if(oldLines==null){
			Book book=BookServiceImpl.getInstance().findBookById(bookId);
			
			Line line=new Line(1,order,book);
			newLines.put(key, line);
		}
		//oldLines中存在且包含目标
		else if(oldLines.containsKey(key)==true){
			Line line=oldLines.get(key);
			line.setNum(line.getNum()+1);
		}
		//newLines中存在
		else if(newLines.containsKey(key)==true){
			Line line=newLines.get(key);
			line.setNum(line.getNum()+1);
		}
		//newLines中不存在
		else{
			Book book=BookServiceImpl.getInstance().findBookById(bookId);
			
			Line line=new Line(1,order,book);
			newLines.put(key, line);
		}
		response.sendRedirect("shopcart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
