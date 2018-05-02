package com.project.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.DTO.BoardDTO;
import com.project.DTO.CriteriaDTO;
import com.project.DTO.NextPreDTO;
import com.project.mybatis.SqlMapConfig;

public class BoardDAO {
				// MyBatis 세팅값 호출
				SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
			
				//mapper에 접근하기 위한 SqlSession
				SqlSession sqlSession;
			    //신상품 조회
				
				private static BoardDAO instance = new BoardDAO();
				public static BoardDAO getInstance() {
					return instance;
				}
				

				public List<BoardDTO> listAll(CriteriaDTO criDto) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					List<BoardDTO> list = null;
				
					
					try {
						
						list = sqlSession.selectList("listCriteria", criDto);
						
						for (BoardDTO boardDTO : list) {
							System.out.print(boardDTO.getBno()+" , ");
							System.out.print(boardDTO.getTitle()+" , ");
							System.out.print(boardDTO.getWriter()+" , ");
							System.out.print(boardDTO.getRegdate()+" , ");
							System.out.print(boardDTO.getViewont()+" , ");
							System.out.println();
							
						}
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return list;
				}
				
				
				public int totalCount(CriteriaDTO criDto) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					
					int result = 0;
					
					try {
						
						result = sqlSession.selectOne("countPaging",criDto);
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					
					return result;
					
				}
				
				
				public int insertBoard(BoardDTO bDto) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					int ruselt = 0;
				
					
					try {
						
						ruselt = sqlSession.insert("insertBoard", bDto);
						
						sqlSession.commit();
						
						if (ruselt > 0 ) {
							
							System.out.println("등록 성공");
							
						}else {
							
							System.out.println("등록 실패");
							
						}
						
						
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return ruselt;
				}
				
				
				public List<BoardDTO> bodylist(int bno) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					List<BoardDTO> list = null;
				
					
					try {
						
						list = sqlSession.selectList("bodylist", bno);
						
						for (BoardDTO boardDTO : list) {
							System.out.print(boardDTO.getBno()+" , ");
							System.out.print(boardDTO.getTitle()+" , ");
							System.out.print(boardDTO.getContent()+" , ");
							System.out.print(boardDTO.getWriter()+" , ");
							System.out.print(boardDTO.getRegdate()+" , ");
							System.out.print(boardDTO.getViewont()+" , ");
							System.out.println();
							
						}
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return list;
				}
				
				public List<BoardDTO> modifyList(int bno) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					List<BoardDTO> list = new ArrayList<>();
				
					
					try {
						
						list = sqlSession.selectList("modfiyList", bno);
						
						for (BoardDTO boardDTO : list) {
							System.out.print(boardDTO.getBno()+" , ");
							System.out.print(boardDTO.getTitle()+" , ");
							System.out.print(boardDTO.getContent()+" , ");
							System.out.print(boardDTO.getWriter()+" , ");
							System.out.print(boardDTO.getRegdate()+" , ");
							System.out.print(boardDTO.getViewont()+" , ");
							System.out.println();
							
						}
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return list;
				}
				
				
				public int modifUpdate(BoardDTO bDto) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					int rusult = 0;
				
					
					try {
						
						rusult = sqlSession.update("modfiyUpdate", bDto);
						sqlSession.commit();
						
						
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return rusult;
				}
				
				public int modifDelete(Integer bno) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					int rusult = 0;
				
					
					try {
						
						rusult = sqlSession.delete("modifDelete", bno);
						sqlSession.commit();
						
						
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return rusult;
				}
				
				
				public int bodylistRead(int bno, HttpSession countSession) {
					
					sqlSession = sqlSessionFactory.openSession();
						
					int result = 0;
					
				
					
					try {
						
						long update_time = 0;
						
						
						// 조회수를 증가 할 때생기는 read_time_게시글번호가 없으면
						// 현재 처음 조회수를 1증가하는 경우임
						if(countSession.getAttribute("read_time_"+bno) != null) {
							
							update_time = (long)countSession.getAttribute("read_time_"+bno);
						}
						
						long current_time = System.currentTimeMillis(); // 현재 시간을 읽어 온다.
						
						
						//현재시간과 조회수 1증가한 시간을 비교해서 24시간(1일)이 지났으면
						// 조회수 1증가
						if(current_time - update_time > 8640 * 1000) { // 5 * 1000 = 5초 5초 뒤에 조회수가 증가한다.
							
							result = sqlSession.update("bodylistRead", bno);
							sqlSession.commit();
							
							// 조회수 1증가한 시간을 session에 담는다.
							countSession.setAttribute("read_time_"+bno, current_time);
						}
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return result;
				}
				
				
				public int bodySweetAdd(int bno, HttpSession countSession, String mid) {
					
					sqlSession = sqlSessionFactory.openSession();
						
					int result = 0;
					
				
					
					try {
						
						long update_time = 0;
						
						
						// 조회수를 증가 할 때생기는 read_time_게시글번호가 없으면
						// 현재 처음 조회수를 1증가하는 경우임
						if(countSession.getAttribute("sessionid_"+mid+bno) != null) {
							
							update_time = (long)countSession.getAttribute("sessionid_"+mid+bno);
						}
						
						long current_time = System.currentTimeMillis(); // 현재 시간을 읽어 온다.
						
						//현재시간과 좋아요 1증가한 시간을 비교해서 24시간(1일)이 지났으면
						// 좋아요 1증가
						if(current_time - update_time > 8640 * 1000) { // 5 * 1000 = 5초 5초 뒤에 조회수가 증가한다.
							
							result = sqlSession.update("bodyseetadd", bno);
							
							sqlSession.commit();
							
							
							// 좋아요 1증가한 시간을 session에 담는다.
							countSession.setAttribute("sessionid_"+mid+bno, current_time);
						}
						
						
						
					
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return result;
				}
				
				
				public List<NextPreDTO> bodyNextBody(int bno) {
					
					sqlSession = sqlSessionFactory.openSession();
						
					List<NextPreDTO> list = new ArrayList<>();
					
					try {
						
						list = sqlSession.selectList("bodynext", bno);
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return list;
				}
				
				
				public int countUpdate(BoardDTO bDto) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					int rusult = 0;
				
					
					try {
						
						rusult = sqlSession.update("countUpdate", bDto);
						sqlSession.commit();
						
						
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return rusult;
				}
				
				
				public String getFileName(int bno) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					String rusult = "";
				
					
					try {
						
						rusult = sqlSession.selectOne("getFileName", bno);
						
						
						
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return rusult;
				}
				
				
				public int downLoadCount(int bno) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					int rusult = 0;
				
					
					try {
						
						rusult = sqlSession.update("downLoadCount", bno);
						
						sqlSession.commit();
						
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
					return rusult;
				}
				
				public void updateStep(int ref, int re_step) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					int rusult = 0;
				
					
					try {
						
						BoardDTO bDto = new BoardDTO();
						bDto.setRef(ref);
						bDto.setRe_step(re_step);
						
						rusult = sqlSession.update("updateStep", bDto);
						
						sqlSession.commit();
						
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						sqlSession.close();
						
					}
				}
				
				public int answerInsert(BoardDTO bDto) {
					
					sqlSession = sqlSessionFactory.openSession();
					
					int rusult = 0;
				
					
					try {
						
						rusult = sqlSession.insert("answerInsert", bDto);
						
						sqlSession.commit();
						
						
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}finally {
						
						if(sqlSession != null)sqlSession.close();
						
					}
					return rusult;
				}
				
				
}
