package com.briup.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Line;

/**
 * Servlet implementation class UpdateLines
 */
@WebServlet("/custom/updateLine")
public class UpdateLines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLines() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String lineKey=request.getParameter("linekey");
		Long key=new Long(lineKey);
		
		Integer num=new Integer(request.getParameter("num"));
		
		Map<Long,Line> oldLines=(Map<Long, Line>) session.getAttribute("oldLines");
		Map<Long,Line> newLines=(Map<Long, Line>) session.getAttribute("newLines");
		
		if(oldLines.containsKey(key)==true){
			Line line=oldLines.get(key);
			line.setNum(num);
		}
		else{
			Line line=newLines.get(key);
			line.setNum(num);
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
