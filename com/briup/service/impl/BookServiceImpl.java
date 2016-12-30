package com.briup.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.briup.bean.Book;
import com.briup.common.Log4jFactory;
import com.briup.common.MapperFactory;
import com.briup.dao.IBookDao;
import com.briup.service.IBookService;

public class BookServiceImpl implements IBookService{
	private static BookServiceImpl bookService=new BookServiceImpl();
	private IBookDao mapper;
	private Logger logger;
	
	protected BookServiceImpl() {}
	
	@Override
	public void addBook(Book book) {
		if(book!=null){
			mapper.addBook(book);
			logger.info("插入成功");
		}
		else{
			logger.error("需要插入有效数据");
		}
	}

	@Override
	public Book findBookById(String id) {
		Book book=mapper.findBookById(new Long(id));
		if(book!=null){
			return book;
		}
		else{
			logger.error("没有查到值");
			return null;
		}
	}

	@Override
	public List<Book> findAllBook() {
		List<Book> books=mapper.findAllBook();
		if(books!=null){
			return books;
		}
		else{
			logger.error("没取到值");
			return null;
		}
	}

	@Override
	public void updateBook(Book book) {
		if(book.getId()!=0 && book.getName()!=null && book.getPrice()>0){
			mapper.updateBook(book);
			logger.info("修改成功");
		}
		else{
			logger.error("非法的用户名id、为空");
		}
	}

	@Override
	public void deleteBook(Long id) {
		
	}
	
//	@Test
	public void test(){
		
	}
	
	public static BookServiceImpl getInstance(){
		bookService.init();
		return bookService;
	}
	
	private void init(){
		mapper=MapperFactory.getSession(true).getMapper(IBookDao.class);
		logger=Log4jFactory.getLogger();
	}
}
