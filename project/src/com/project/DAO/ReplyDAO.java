package com.project.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.DTO.ReplyDTO;
import com.project.mybatis.SqlMapConfig;

public class ReplyDAO {
	
	// MyBatis 세팅값 호출
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

	//mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
    //신상품 조회
	
	private static ReplyDAO instance = new ReplyDAO();
	public static ReplyDAO getInstance() {
		return instance;
	}
	
	public List<ReplyDTO> replyList(int bno) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		List<ReplyDTO> list = null;
	
		
		try {
			
			list = sqlSession.selectList("replyList", bno);

			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
			
		}
		return list;
	}
	
	public int replyCount(int bno) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		List<ReplyDTO> list = null;
	
		int count = 0;
		try {
			
			list = sqlSession.selectList("replycount", bno);
			
			
			for (ReplyDTO replyDTO : list) {
				count = replyDTO.getCount();
			}

			System.out.println(count);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
			
		}
		return count;
	}
	
	
		public int replyInsert(int bno, String connect, String mid) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		int result=0;
	
		try {
			
			ReplyDTO rDto = new ReplyDTO(bno, connect, mid);
			
			result = sqlSession.insert("replyinsert", rDto);
			
			sqlSession.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
			
		}
		return result;
	}
		
		
		public int replyDelete(int rno) {
			
			sqlSession = sqlSessionFactory.openSession();
			
			int result=0;
		
			try {
				
				result = sqlSession.delete("replydelete", rno);
				
				sqlSession.commit();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}finally {
				
				sqlSession.close();
				
			}
			return result;
		}
		
		public int replyAllDelete(int bno) {
			
			sqlSession = sqlSessionFactory.openSession();
			
			int result=0;
		
			try {
				
				result = sqlSession.delete("replyAllDelete", bno);
				
				sqlSession.commit();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}finally {
				
				sqlSession.close();
				
			}
			return result;
		}

}
