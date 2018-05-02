package com.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.ReplyDAO;
import com.project.DTO.ReplyDTO;

public class CommentListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "board/commentlist.jsp";
		
		String bno = request.getParameter("bno");
		
		System.out.println("bno : " + bno);
		
		
		int num =  Integer.parseInt(bno);
		
		
		//상세페이지 댓글 출력하기
		
				List<ReplyDTO> list = null;
				ReplyDAO rDao = ReplyDAO.getInstance();
				list = rDao.replyList(num);
				request.setAttribute("replylist", list);
				
				
				ActionForward forward = new ActionForward();
				
				forward.setPath(url);
				forward.setRedirect(false); 
			
				return forward;
	}

}
