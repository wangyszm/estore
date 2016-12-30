package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.bean.Book;

/**
 * 书的Dao层
 * @author Administrator
 *
 */
public interface IBookDao {
	
	/**
	 * 添加书
	 */
	void addBook(Book book);
	
	/**
	 * 通过id找书
	 */
	Book findBookById(Long id);
	
	/**
	 * 找所有的书
	 */
	List<Book> findAllBook();
	
	/**
	 * 修改一本书
	 */
	void updateBook(Book book);
	
	/**
	 * 删除书
	 */
	void deleteBook(Long id);
}
