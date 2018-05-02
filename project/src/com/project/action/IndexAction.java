package com.project.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.ProductDAO;
import com.project.DTO.ProductDTO;

public class IndexAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "index.jsp";
		
		
		ProductDAO pDao = ProductDAO.getInstance();
		
		List<ProductDTO> newProductlist = new ArrayList<>();

		newProductlist = pDao.imagelist();
		
		request.setAttribute("newProductlist", newProductlist);
	
		
		List<ProductDTO> newProductlist2 = new ArrayList<>();
		
		newProductlist2 = pDao.bestlist();
		
		request.setAttribute("newProductlist2", newProductlist2);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath(url);
		forward.setRedirect(false); 
		
		return forward;
	}
	
}
