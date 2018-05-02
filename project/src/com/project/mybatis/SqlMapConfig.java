package com.project.mybatis;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
			String resource = "com/project/mybatis/Configuration.xml";
	
		try {
			// 매개변수를 읽어온다.
			Reader reader =Resources.getResourceAsReader(resource);
			
			
			if(sqlSessionFactory == null) {
				// 환경 설정 해놓은 것을 불러 와라.
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
	
}
