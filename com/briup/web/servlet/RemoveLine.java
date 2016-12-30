package com.briup.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Line;

/**
 * Servlet implementation class RemoveLine
 */
@WebServlet("/custom/removeLine")
public class RemoveLine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveLine() {
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
		
		Map<Long,Line> oldLines=(Map<Long, Line>) session.getAttribute("oldLines");
		Map<Long,Line> newLines=(Map<Long, Line>) session.getAttribute("newLines");
		Map<Long,Line> deleteLines=(Map<Long, Line>) session.getAttribute("deleteLines");
		
		if(deleteLines.containsKey(key)==false){
			if(oldLines.containsKey(key)==true){
				deleteLines.put(key, oldLines.get(key));
				oldLines.remove(key);
			}
			else{
				deleteLines.put(key, newLines.get(key));
				newLines.remove(key);
			}
		}
		else{
			oldLines.remove(key);
			newLines.remove(key);
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
