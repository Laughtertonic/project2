package com.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.BoardDAO;
import com.project.DTO.BoardDTO;

public class ModifyAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<BoardDTO> list = null;
		
		String url = "board/modifyboard.jsp";
		
		System.out.println(url);
		
		String bno = request.getParameter("bno");
		
		int num = Integer.parseInt(bno);
		
		BoardDAO bDao = BoardDAO.getInstance();
		list = bDao.modifyList(num);
		request.setAttribute("modifylist", list);

		ActionForward forward = new ActionForward();
		

		
		forward.setPath(url);
		forward.setRedirect(false); 
		
		return forward;
	}

}
