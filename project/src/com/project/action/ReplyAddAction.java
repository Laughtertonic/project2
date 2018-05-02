package com.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.project.DAO.ReplyDAO;

public class ReplyAddAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "boardbody.bizpoll";
		
		String mid = request.getParameter("mid");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String comment = request.getParameter("comment_text");
		
		System.out.println( mid + " , " + bno + " , " + comment);
		
		ReplyDAO rDao = ReplyDAO.getInstance();
		
		int result = rDao.replyInsert(bno, comment,  mid);
		
		if (result > 0) {
			
			System.out.println("등록 성공");
			
		}else {
			
			System.out.println("등록 실패");
			
		}
		
		JSONObject jjb = new JSONObject();
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(jjb);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false); 
	
		return null;
	}

}
