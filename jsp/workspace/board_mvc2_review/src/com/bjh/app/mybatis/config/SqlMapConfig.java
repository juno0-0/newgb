package com.bjh.app.mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory session_f;
	
	static {
		try {
			String resource = "./com/bjh/app/mybatis/config/config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			session_f = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			System.out.println("SqlMapConfig : "+e.getMessage());
			throw new RuntimeException("초기화 문제 발생, SqlMapConfing.java");
		}
	}
	
	public static SqlSessionFactory getSqlMapInstance() {
		return session_f;
	}
}
