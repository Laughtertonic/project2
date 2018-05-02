package com.project.action;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.BoardDAO;
import com.project.common.Constants;

public class DownLoadAction  implements Action {
	
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			
			int bno = Integer.parseInt(request.getParameter("bno"));
			
			// 다운로드할 파일 DB에서 가져옴
			BoardDAO bDao = BoardDAO.getInstance();
			String filename = bDao.getFileName(bno);
			bDao.downLoadCount(bno); // 다운로드 하면 값을 1 증가 시켜준다.
			
			System.out.println("filename = " + filename);
			
			//다운로드할 파일 경로
			String path = Constants.UPLOAD_PATH+filename;
			byte b[] = new byte[4096]; // 바이트 배열 생성
			
			
			// 서버에 저장된 파일을 읽기 위한 스트림 생성
			FileInputStream fis = new FileInputStream(path);
			
			// mimeType(파일의 종류)
			String mimeType = request.getServletContext().getMimeType(path);
			if(mimeType == null) {
				
				mimeType = "application/octet-stream; charset=utf-8";
				
			}
			
			//파일 이름에 한글이 포함된 경우
			// new String (바이트배열, 변환할 인코딩) 8859_1 서유럽언어
			// header에 특수문자 사용 못함, 서유럽언어로 변환
			filename = new String(filename.getBytes("utf-8"),"8859_1");
			
			
			//http header
			response.setHeader("content-Disposition", "attachment;filename="+filename);
			
			//http body
			// OutputStream 생성(서버에서 클라이언트에 쓰기)
			ServletOutputStream out = response.getOutputStream();
			
			
			int numRead;
			while(true) {
				
				numRead = fis.read(b, 0, b.length); // 데이터 읽기 (4096 byte씩 끊어서 읽는다)
				if(numRead == -1) break;
				out.write(b, 0, numRead);
			}
			
			// 파일 처리 관련 리소스 정리
			out.flush(); // 만약 4000byte씩 담는다고 가정하고 10000byte
			out.close();
			fis.close();
			
			
			// 게시글 파일 다운로드
			// 클라이언트				서버
			// 					<====== 파일
			//							InputStream(파일 읽기)
			//							OutputSteam(파일 쓰기)
		
		return null;
	}
}
