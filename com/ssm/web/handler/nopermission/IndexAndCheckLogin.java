package com.ssm.web.handler.nopermission;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.bean.Book;
import com.ssm.common.ContainerFactory;
import com.ssm.service.BookService;
/**
 * 跳转到主页
 * @author Administrator
 *
 */
@Controller
public class IndexAndCheckLogin{
	
	@RequestMapping(value={"/","/index"})
	public String indexRequest(HttpServletRequest request,HttpServletResponse response){
		ServletContext application=request.getServletContext();
		
		if(application.getAttribute("books")==null){
			ApplicationContext container=ContainerFactory.getInstance().getContainer();
			BookService bookService=(BookService) container.getBean("bookService");
			
	//		List<Book> books = bookService.getBooks();
			Map<Long,Book> books = bookService.getBooks();
			application.setAttribute("books", books);
		}
		return "index";
	}
	
}
