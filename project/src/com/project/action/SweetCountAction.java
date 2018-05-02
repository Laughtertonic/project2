package com.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.BoardDAO;
import com.project.DTO.BoardDTO;

public class SweetCountAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "board/sweetcountjsp.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		List<BoardDTO> list = null;
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		list = bDao.bodylist(bno);
		
		request.setAttribute("bodylist", list);
		

		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false); 
		
		return forward;
		
	}

}
