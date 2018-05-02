package com.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

public class LoginOutAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int flag = 0;
		
		HttpSession session = request.getSession(false); // 그냥 널 값을 반환시켜주고, ture면 생성해준다.
		
		if(session != null) {
			
			session.invalidate();
			flag = 1;
			
		}else {
			
			flag = 0;
		}
		
		System.out.println(flag);
		
		JSONObject jjb = new JSONObject();
		
		jjb.put("flag", flag);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(jjb);
		
		//ActionForward forward = new ActionForward();
		
		//forward.setPath(url);
		//forward.setRedirect(false); 
		
		return null;
	}

}
