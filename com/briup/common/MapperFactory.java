package com.briup.common;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MapperFactory {
	private static SqlSessionFactory factory;
	
	static{
		try {
			factory=new SqlSessionFactoryBuilder()
						.build(Resources.getResourceAsStream("mybatis-config.xml"),"test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession(boolean autoCommit){
		SqlSession session=factory.openSession(autoCommit);
		return session;
	}
}
