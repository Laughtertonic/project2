package com.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.MemberDAO;

public class IdolapckAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "id_olap_ck.jsp";
		
		String memberid = request.getParameter("memberid");
		System.out.println("ID = " + memberid);
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int flag = mDao.memIdCheck(memberid);
		
		// flag가 0이면 중복, 1이면 사용가능
		
		request.setAttribute("flag", flag);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false); 
		
		return forward;
	}

}
