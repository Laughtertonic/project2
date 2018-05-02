package com.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.BoardDAO;
import com.project.DAO.SearchDAO;
import com.project.DTO.BoardDTO;
import com.project.DTO.CriteriaDTO;
import com.project.DTO.PageMakerDTO;

public class SearchAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<BoardDTO> list = null;
		SearchDAO sDao = SearchDAO.getInstance();
		//String url = "boardbody.bizpoll";
		
		String select = request.getParameter("sfl");
		String search = request.getParameter("stx");
		
		System.out.println(select + " , " + search);
		
		
		
		String url = "board/Fboardlist.jsp";
		
		
		CriteriaDTO criDto = new CriteriaDTO();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		System.out.println("페이지 번호" + page);
		criDto.setPage(page);
		
		criDto.setSelect(select);
		criDto.setSearch(search);
		list = sDao.searchTitle(criDto); // = list (게시글 목록)
		
		BoardDAO bDao = BoardDAO.getInstance();
		request.setAttribute("boardlist", list);
		
		PageMakerDTO pageMaker = new PageMakerDTO();
		pageMaker.setCriDto(criDto);
		int totalcount = bDao.totalCount(criDto);
		
		System.out.println("전체 카운트 " + totalcount);
		
		pageMaker.setTotalCount(totalcount);
		
		int count = list.size();
		String flag = "1";
		
		request.setAttribute("sfl", select);
		request.setAttribute("stx", search);
		
		request.setAttribute("flag", flag);
		request.setAttribute("count", count);
		request.setAttribute("pageMaker", pageMaker);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false); 
	
		return forward;
	}

}
