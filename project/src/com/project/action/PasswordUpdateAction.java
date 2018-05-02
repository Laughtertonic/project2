package com.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.project.DAO.MemberDAO;
import com.project.DTO.MemberDTO;

public class PasswordUpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = new MemberDTO(mid, mpw);
		int flag = mDao.passwordUpdate(mDto);
		
		
		JSONObject jjb = new JSONObject();
		
		
		jjb.put("flag", flag);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(jjb);
		
		return null;
	}

}
