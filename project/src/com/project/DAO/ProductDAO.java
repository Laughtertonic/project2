package com.project.DAO;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.DTO.ProductDTO;
import com.project.mybatis.SqlMapConfig;



public class ProductDAO {
	
		// MyBatis 세팅값 호출
		SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
		//mapper에 접근하기 위한 SqlSession
		SqlSession sqlSession;
	    //신상품 조회
		
	    public List<ProductDTO> imagelist() {
	    	
	    	List<ProductDTO> list = new ArrayList<>();
	    	
	    	sqlSession = sqlSessionFactory.openSession();
	    	
	    	try {
	    		
	    		list = sqlSession.selectList("newpdtview");
	    		
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
	    	
	    	return list;
	    }
	    
	    
	    
	    
	    public List<ProductDTO> bestlist() {
	    	List<ProductDTO> list = new ArrayList<>();
	    	
	    	sqlSession = sqlSessionFactory.openSession();
	    	
	    	try {
	    		
	    		list = sqlSession.selectList("bestview");
	    		
	    		
	    		
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}finally {
				
				sqlSession.close();
			}
	    	
	    	return list;
	    }
	    
	    private static ProductDAO instance = new ProductDAO();
		public static ProductDAO getInstance() {
			return instance;
		}

		

}
