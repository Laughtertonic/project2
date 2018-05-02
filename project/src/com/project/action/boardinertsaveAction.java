package com.project.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.DAO.BoardDAO;
import com.project.DTO.BoardDTO;
import com.project.common.Constants;

public class boardinertsaveAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "boardlist.bizpoll";
		
		
		//파일 업로드 처리
	
		File uploadDir = new File(Constants.UPLOAD_PATH);
		
		//파일을 저장할 디렉토리가 존재하지 않다면 디렉토리 생성
		
		if(!uploadDir.exists()) {
			
	         uploadDir.mkdir();
	      }
		
		// request를 확장시킨 MultipatRequest 생성
		// new MultipartRequest(request, 파일 디렉토리 , 업로드 용량 , 인코딩, 파일이름중복정책)
		MultipartRequest multi = new MultipartRequest(request, Constants.UPLOAD_PATH, Constants.MAX_UPLOAD, "UTF-8" , new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");
		String file = multi.getParameter("files");
		String filename = " ";//공백 한칸 뛰어야 한다.
		int filesize = 0;
		
		
		System.out.println(" title : " + title + " content : " + content + " writer : " + writer + " files = " + file);
		
		
		try {
			//첨부파일의 집합(배열로 가져옴)
			Enumeration files = multi.getFileNames();
			
			while (files.hasMoreElements()) {
				//첨부파일의 이름
				String file1 = (String)files.nextElement();
				filename = multi.getFilesystemName(file1);
				File f1 = multi.getFile(file1);
				
				if(f1 != null) {
					
					filesize =(int)f1.length(); //파일 사이즈 저장
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		//filename 이름이 null이거나 공백일때 "-" 처리
		if(filename == null || filename.trim().equals("")) {
			filename = "-";
		}
		
		
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		
		BoardDTO bDto = new BoardDTO(title, content, writer, filename, filesize);
		
		bDao.insertBoard(bDto);
		
		//게시글을 등록하고 게시글 목록으로 이동
		
		
		
	
		ActionForward forward = new ActionForward();
	
		forward.setPath(url);
		forward.setRedirect(true); 
	
		return forward;
	}

}
