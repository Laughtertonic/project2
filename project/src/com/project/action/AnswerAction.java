package com.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.BoardDAO;
import com.project.DTO.BoardDTO;

public class AnswerAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<BoardDTO> list = null;
		BoardDTO bDto = new BoardDTO();
		
		String url = "board/answerread.jsp";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		System.out.println("bno = " + bno);
		
		BoardDAO bDao = BoardDAO.getInstance();
		list = bDao.bodylist(bno);
		
		//bDto.setContent("======게시물의 내용======\n"+bDto.getContent());
		request.setAttribute("list", list);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false); 
	
		return forward;
	}

}
