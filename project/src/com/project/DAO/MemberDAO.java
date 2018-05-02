package com.project.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.DTO.MemberDTO;
import com.project.mybatis.SqlMapConfig;


public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int result, flag;
	
	// MyBatis 세팅값 호출
			SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
		
			//mapper에 접근하기 위한 SqlSession
			SqlSession sqlSession;
		    //신상품 조회
	
	// ID 중복 체크
	
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}

	
	public int memIdCheck(String mid) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		List<MemberDTO> list = null;
	
		
		try {
			
			list = sqlSession.selectList("memIdCheck", mid);
			
				
				if(list.size() > 0) {
					
					System.out.println("중복된 ID 입니다.");
					flag = 0;
					
				}else {
					
					System.out.println("사용가능한 ID 입니다.");
					flag = 1;
					
				}
			
			
		
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
			
		}
		return flag;
	}
	//아이디 체크
	public int memLogin(MemberDTO mDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		List<MemberDTO> list = null;
		
		try {
			String id = mDto.getMid();
			String pw = mDto.getMpw();
			
			Map map = new HashMap();
			map.put("id", id);
			map.put("pw", pw);
			
			list = sqlSession.selectList("memlogin", map);
			
			
			
			
			
			System.out.println(list.size());
			
			if(list.size() > 0) {
				
				System.out.println("로그인 성공");
				
				flag = 1;
				
			}else {
				
				System.out.println("로그인 실패");
				
				flag = 0;
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
			
		}
		return flag;
	}
	//회원 등록
	
	public int memIsert(MemberDTO mDto) {
		
			sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			result = sqlSession.insert("memIsert", mDto);
			
			
			
			if(result > 0 ) {
				
				System.out.println("등록 성공");
				
			} else {
				
				System.out.println("등록 실패");
			
			}
			
			sqlSession.commit();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
		}
		return result;
	}
	
	public int memUpdate(MemberDTO mDto) {
		
			sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			result = sqlSession.insert("memUpdate", mDto);
			
			sqlSession.commit();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
		}
		return result;
}
	
		public int memDelete(String mid) {
		
				sqlSession = sqlSessionFactory.openSession();
			
			try {
				
				result = sqlSession.delete("memDelete", mid);
				
				sqlSession.commit();
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}finally {
				
				sqlSession.close();
			}
			return result;
	}
	
	//세션에 저장할 값들을 불러오기
	public MemberDTO sessionLogin(MemberDTO mDto) {
		
		List<MemberDTO> list = null;
		
		sqlSession = sqlSessionFactory.openSession();
		
		
		try {
			
			
			
		
			
			
			list = sqlSession.selectList("sessionLogin", mDto);
			
			for (MemberDTO memberDTO : list) {
				
				String mid = memberDTO.getMid();
				String mpw = memberDTO.getMpw();
				String mname = memberDTO.getMname();
				String mphone = memberDTO.getMphone();
				String mjusonum = memberDTO.getMjusonum();
				String mjuso = memberDTO.getMjuso();
				String mjuso2 = memberDTO.getMjuso2();
				String mbirthyear = memberDTO.getMbirthyear();
				String mbirthmonth = memberDTO.getMbirthmonth();
				String mbirthday = memberDTO.getMbirthday();
				String memail = memberDTO.getMemail();
				String memail2 = memberDTO.getMemail2();
				String mmen = memberDTO.getMmen();
				Date regdate = memberDTO.getRegdate();
				
				mDto = new MemberDTO(mid, mpw, mname, mphone, mjusonum, mjuso, mjuso2, memail, memail2, mbirthyear, mbirthmonth, mbirthday, mmen, regdate);
			
			
				System.out.println(" 이름 = " + mname);
			
			}
			
			
			
			/*for (int i = 0; i < list.size(); i++) {
				
				
				
				String mid = (String)map.get("MID");
				String mpw = (String)map.get("MPW");
				String mname = (String)map.get("MNAME");
				String memail = (String)map.get("MEMAIL");
				String memail2 = (String)map.get("MEMAIL2");
				String mbirthyear = (String)map.get("MBIRTHYEAR");
				String mbirthmonth = (String)map.get("MBIRTHMONTH");
				String mbirthday = (String)map.get("MBIRTHDAY");
				String mjusonum = (String)map.get("MJSUONUM");
				String mjuso = (String)map.get("MJSUO");
				String mjuso2 = (String)map.get("MJSUO2");
				String mphone = (String)map.get("MPHONE");
				String mmen = (String)map.get("MMEN");
				Date regdate = (Date)map.get("REGDATE");
				
				mDto = new MemberDTO(mid, mpw, mname, mphone, mjusonum, mjuso, mjuso2, memail, memail2, mbirthyear, mbirthmonth, mbirthday, mmen, regdate);
				
				System.out.print(mid + " , ");
				System.out.print(mpw + " , ");
				System.out.print(mname + " , ");
				System.out.println();
			}*/
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
			
		}
		return mDto;
	}

	public MemberDTO personalSelect(String mid) {
		
	
		sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDto = new MemberDTO();
		List<MemberDTO> list = null;
		
		try {
			
			list = sqlSession.selectList("personalSelect", mid);
			
			for (MemberDTO memberDTO : list) {
				mid = memberDTO.getMid();
				String mpw = memberDTO.getMpw();
				String mname = memberDTO.getMname();
				String mphone = memberDTO.getMphone();
				String mjusonum = memberDTO.getMjusonum();
				String mjuso = memberDTO.getMjuso();
				String mjuso2 = memberDTO.getMjuso2();
				String mbirthyear = memberDTO.getMbirthyear();
				String mbirthmonth = memberDTO.getMbirthmonth();
				String mbirthday = memberDTO.getMbirthday();
				String memail = memberDTO.getMemail();
				String memail2 = memberDTO.getMemail2();
				String mmen = memberDTO.getMmen();
				Date regdate = memberDTO.getRegdate();
				
				mDto = new MemberDTO(mid, mpw, mname, mphone, mjusonum, mjuso, mjuso2, memail, memail2, mbirthyear, mbirthmonth, mbirthday, mmen, regdate);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
			
		}
		return mDto;

	}
	
	
	public int passwordUpdate(MemberDTO mDto) {
		
			sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			result = sqlSession.update("passwordUpdate", mDto);
			
			
			
			if(result > 0 ) {
				
				System.out.println("비번 변경 성공");
				
			} else {
				
				System.out.println("비번 변경 실패");
			
			}
			
			sqlSession.commit();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			sqlSession.close();
		}
		return result;
}

	

	
}
