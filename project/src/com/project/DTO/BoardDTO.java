package com.project.DTO;

import java.util.Date;

public class BoardDTO {
	
	private int bno;
	private String  title;
	private String  content;
	private String  writer;
	private Date regdate;
	private int viewont;
	private int sweet;
	private int count;
	private String  filename;
	private int filesize;
	private int  ref;
	private int  re_step;
	private int  re_level;
	private int downloadcnt;
	
	
	
	
	public BoardDTO() {}
	
	
	
	public BoardDTO( String title, String content, String writer, String filename, int filesize, int ref,
			int re_step, int re_level) {
		super();
		
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.filesize = filesize;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
	}



	public BoardDTO(int bno, String title, String content, String writer, Date regdate, int viewont, int count) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewont = viewont;
		this.count = count;
	}
	
	public BoardDTO(int bno, int count) {
		super();
		this.bno = bno;
		this.count = count;
	}

	public BoardDTO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	

	public BoardDTO(int bno, String title, String content, String writer) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	
	

	public BoardDTO(int bno, String title, String content, String writer, String filename, int filesize) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.filesize = filesize;
	}

	public BoardDTO(String title, String content, String writer, String filename, int filesize) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.filesize = filesize;
	}
	
	

	public int getRe_level() {
		return re_level;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

	public int getDownloadcnt() {
		return downloadcnt;
	}

	public void setDownloadcnt(int downloadcnt) {
		this.downloadcnt = downloadcnt;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRe_step() {
		return re_step;
	}

	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}

	public int getRe_levle() {
		return re_level;
	}

	public void setRe_levle(int re_levle) {
		this.re_level = re_levle;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getViewont() {
		return viewont;
	}


	public void setViewont(int viewont) {
		this.viewont = viewont;
	}

	public int getSweet() {
		return sweet;
	}

	public void setSweet(int sweet) {
		this.sweet = sweet;
	}
}
