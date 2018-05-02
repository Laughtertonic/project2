package com.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.project.DAO.MemberDAO;

public class MemAjaxAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String mid = request.getParameter("id2");
		System.out.println("ID = "+ mid);
		
		
		
		if(mid != null) {
			
			if(mid.trim().equals("") == false) {
				
				MemberDAO mDao = MemberDAO.getInstance();
				int flag = mDao.memIdCheck(mid);
				
				System.out.println("flag = " + flag);
				
				JSONObject jjb = new JSONObject();
				jjb.put("flag", flag);
				jjb.put("id2", mid);
				
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().println(jjb);
				
				
			}
		}
		
		//ActionForward forward = new ActionForward();
		
		
		
		return null;
	}

}
