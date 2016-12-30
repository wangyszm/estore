package com.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ssm.bean.Book;
import com.ssm.common.ContainerFactory;
import com.ssm.dao.IBookDao;

@Service("bookService")
public class BookService {
	
	public Map<Long,Book> getBooks(){
		ApplicationContext container = ContainerFactory.getInstance().getContainer();
//		IBookDao book=(IBookDao) container.getBean("IBookDao");
//		List<Book> books = book.findAllBook();
		
		//利用mybatis获得book的map集合，将之添加至application中
		//使得不需要每一个用户进入首页都要读取数据库
		DefaultSqlSessionFactory factory=(DefaultSqlSessionFactory)container.getBean("sqlSession");
		SqlSession sqlSession = SqlSessionUtils.getSqlSession(factory);
		
		Map<Long, Book> books = sqlSession.selectMap("com.ssm.dao.IBookDao.findAllBook", "id");
		
		return books;
	}
	
	/**
	 * 单元测试用方法
	 */
	@Test
	public void test() throws Exception{
		ApplicationContext container = ContainerFactory.getInstance().getContainer();
		IBookDao book=(IBookDao) container.getBean("IBookDao");
//		List<Book> books = book.findAllBook();
		DefaultSqlSessionFactory factory=(DefaultSqlSessionFactory)container.getBean("sqlSession");
		SqlSession sqlSession = SqlSessionUtils.getSqlSession(factory);
		
		Map<Long, Book> map = sqlSession.selectMap("com.ssm.dao.IBookDao.findAllBook", "id");
		System.out.println(map);
	}
}
