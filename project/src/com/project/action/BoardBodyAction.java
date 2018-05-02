package com.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.BoardDAO;
import com.project.DAO.ReplyDAO;
import com.project.DTO.BoardDTO;
import com.project.DTO.NextPreDTO;

public class BoardBodyAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<BoardDTO> list = null;
		List<NextPreDTO> list2 = null;
		String url = "board/substance.jsp";
		
		String bno = request.getParameter("bno");
		
		String comment = request.getParameter("comment");
		
		System.out.println("bno : " + bno);
		
		
		int num =  Integer.parseInt(bno);
		
		
		//등록된 게시글을 본문에 출력하기
		BoardDAO bDao = BoardDAO.getInstance();
		list = bDao.bodylist(num);
		list2 = bDao.bodyNextBody(num);
		
		request.setAttribute("bodylist", list);
		request.setAttribute("bodynext", list2);
		request.setAttribute("comment", comment);
		
		// 조회수 1 증가
		// 섹션을 선언 하고 섹션값을 가져와서 섹션값도 같이 보내준다.
		HttpSession session = request.getSession();
		bDao.bodylistRead(num, session); 
		
		
		
		// 상세페이지에서 댓글 갯수 구하기
		ReplyDAO rDao = ReplyDAO.getInstance();
		int count = rDao.replyCount(num);
		BoardDTO bDto = new BoardDTO(num, count);
		bDao.countUpdate(bDto);
		
		request.setAttribute("count", count);
		
		
	
		ActionForward forward = new ActionForward();
	
		forward.setPath(url);
		forward.setRedirect(false); 
	
		return forward;
	}

}
