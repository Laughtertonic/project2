package com.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.project.DAO.BoardDAO;

public class SweetAddAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "boardbody.bizpoll";
		int bno = Integer.parseInt(request.getParameter("bno"));
		String mid = request.getParameter("mid");
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		// 좋아요 1번만 하게 하기
		HttpSession session = request.getSession();
		bDao.bodySweetAdd(bno , session, mid);
		
		
		JSONObject jjb = new JSONObject();
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(jjb);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false); 
		
		return null;
	}

}
