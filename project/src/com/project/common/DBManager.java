package com.project.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;






public class DBManager {
			
			
			private static Connection conn;
			
			/*private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
			private final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			private final static String USER = "java";
			private final static String PASSWORD ="1234"; */
	
			
			private DBManager(){
	
			}

			public static Connection getConnection(){
					conn = null;
					
					if(conn == null){
						try{
							Context initContext = new InitialContext();
							Context envContext = (Context)initContext.lookup("java://comp/env"); // lookup방식이라 Context로 형변환
							DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); // server.xml의 DB이름을 적어 줌
							
							
							conn=ds.getConnection();
						}catch (Exception e){
							e.printStackTrace();
							
						}
					}
					return conn;
			}
			public static void close(Connection conn , PreparedStatement pstmt , ResultSet rs){
				try {
					if(conn != null){
							try {
										conn.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
					}
					
						if(pstmt != null){
								try {
											pstmt.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
						}
						
							if(rs != null){
									try {
												rs.close();
									} catch (Exception e) {
										e.printStackTrace();
									}
							}
					
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
				// insert , update , delete close 메소드
				public static void close(Connection conn , PreparedStatement pstmt){
					try {
						if(conn != null){
								try {
											conn.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
						}
						
							if(pstmt != null){
									try {
												pstmt.close();
									} catch (Exception e) {
										e.printStackTrace();
									}
							}
							
						
					} catch (Exception e) {
							e.printStackTrace();
					}
					
					
				}
			
				
				
				
			
			
			
			
			
					
}
