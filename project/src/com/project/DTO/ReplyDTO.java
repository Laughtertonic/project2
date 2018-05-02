package com.project.DTO;

import java.util.Date;

public class ReplyDTO {
	
	private int rno;
	private String content;
	private  String writer;
	private  Date regdata ;
	private   int bno;
	private int count;
	 
	public ReplyDTO() {}

	public ReplyDTO(int rno, String content, String writer, Date regdata, int bno) {
		super();
		this.rno = rno;
		this.content = content;
		this.writer = writer;
		this.regdata = regdata;
		this.bno = bno;
	}
	
	public ReplyDTO(int bno, String content, String writer) {
		super();
		this.bno = bno;
		this.content = content;
		this.writer = writer;
	}

	public ReplyDTO(String content) {
		super();
		this.content = content;
	}
	
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
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

	public Date getRegdata() {
		return regdata;
	}

	public void setRegdata(Date regdata) {
		this.regdata = regdata;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	

}
