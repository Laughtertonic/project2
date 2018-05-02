package com.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.MemberDAO;
import com.project.DTO.MemberDTO;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = null;
		
		String mid = request.getParameter("mb_id");
		String mname = request.getParameter("mb_name");
		String memail = request.getParameter("mb_email");
		String memail2 = request.getParameter("mb_email2");
		String mphone = request.getParameter("mb_hp");
		String mbirthyear = request.getParameter("reg_mb_month");
		String mbirthmonth = request.getParameter("user_birth_month");
		String mbirthday = request.getParameter("user_birth_day");
		String mmen = request.getParameter("reg_mb_sung");
		String mjusonum = request.getParameter("sample6_postcode");
		String mjuso = request.getParameter("sample6_address");
		String mjuso2 = request.getParameter("sample6_address2");
		
		System.out.println(mid + " , " + " , " + mname+ " , " + mphone+ " , " + memail+ " , " + memail2 + " , " + 
		mbirthyear+ " , " +mbirthmonth+ " , " +mbirthday+ " , " +mmen + " , " + mjusonum+ mjuso + " , "+ mjuso2 + " , ");
		
		MemberDAO mDAO = MemberDAO.getInstance();
		MemberDTO mDto = new MemberDTO(mid, mphone, mjusonum, mjuso, mjuso2, memail, memail2, mbirthyear, mbirthmonth, mbirthday);
		int result = mDAO.memUpdate(mDto);
		
		if( result > 0 ) { // 회원정보 수정
			
			url = "personal.bizpoll?mid="+mid;
			
		} else {
			
			url = "personal.bizpoll?mid="+mid;
			
		}
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false); 
		return forward;
	}

}
