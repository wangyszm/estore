package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

/**
 * 与书的数据有关的service
 * @author Administrator
 *
 */
public interface IBookService {
	
	/**
	 * 添加新书
	 */
	public void addBook(Book book);
	
	/**
	 * 查找某一本书
	 */
	public Book findBookById(String id);
	
	/**
	 * 查询所有的书
	 */
	public List<Book> findAllBook();
	
	/**
	 * 更新书信息
	 */
	public void updateBook(Book book);
	
	/**
	 * 删除一本书
	 */
	public void deleteBook(Long id);
}
