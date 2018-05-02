package com.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.MemberDAO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String url = "index.bizpoll";
		
		String mid = request.getParameter("mid");
		
		System.out.println("mid = "+ mid);
		
		MemberDAO dDao = MemberDAO.getInstance();
		int flag = dDao.memDelete(mid);
		
		if (flag > 0 ) {
			
			System.out.println("회원 탈퇴 성공");
			url = "index.bizpoll";
			session.removeAttribute("loginUser"); // 세션초기화(혹시 모를 남아있는 값)
			
		}else {
			
			System.out.println("회원 탈퇴 실패");
			url = "personal.bizpoll?mid="+mid;
		}
		
		ActionForward forward = new ActionForward();
	
		forward.setPath(url);
		forward.setRedirect(false); 
	
		return forward;
	}

}
