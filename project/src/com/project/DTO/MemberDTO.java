package com.project.DTO;

import java.sql.Date;

public class MemberDTO {
	
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	private String mjusonum;
	private String mjuso;
	private String mjuso2;
	private String memail;
	private String memail2;
	private String mbirthyear;
	private String mbirthmonth;
	private String mbirthday;
	private String mmen;
    private Date regdate;
    
    public MemberDTO() {}
    
    
	public MemberDTO(String mid, String mpw) {
		super();
		this.mid = mid;
		this.mpw = mpw;
	}

	public MemberDTO(String mid, String mpw, String mname, String mphone, String mjusonum, String mjuso, String mjuso2,
			String memail, String memail2, String mbirthyear, String mbirthmonth, String mbirthday, String mmen,
			Date regdate) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
		this.mjusonum = mjusonum;
		this.mjuso = mjuso;
		this.mjuso2 = mjuso2;
		this.memail = memail;
		this.memail2 = memail2;
		this.mbirthyear = mbirthyear;
		this.mbirthmonth = mbirthmonth;
		this.mbirthday = mbirthday;
		this.mmen = mmen;
		this.regdate = regdate;
	}
	
	


	public MemberDTO(String mid, String mpw, String mname, String mphone, String mjusonum, String mjuso, String mjuso2,
			String memail, String memail2, String mbirthyear, String mbirthmonth, String mbirthday, String mmen) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
		this.mjusonum = mjusonum;
		this.mjuso = mjuso;
		this.mjuso2 = mjuso2;
		this.memail = memail;
		this.memail2 = memail2;
		this.mbirthyear = mbirthyear;
		this.mbirthmonth = mbirthmonth;
		this.mbirthday = mbirthday;
		this.mmen = mmen;
	}
	
	


	public MemberDTO(String mid, String mphone, String mjusonum, String mjuso, String mjuso2, String memail,
			String memail2, String mbirthyear, String mbirthmonth, String mbirthday) {
		super();
		this.mid = mid;
		this.mphone = mphone;
		this.mjusonum = mjusonum;
		this.mjuso = mjuso;
		this.mjuso2 = mjuso2;
		this.memail = memail;
		this.memail2 = memail2;
		this.mbirthyear = mbirthyear;
		this.mbirthmonth = mbirthmonth;
		this.mbirthday = mbirthday;
	}


	public String getMjusonum() {
		return mjusonum;
	}


	public void setMjusonum(String mjusonum) {
		this.mjusonum = mjusonum;
	}


	public String getMjuso2() {
		return mjuso2;
	}


	public void setMjuso2(String mjuso2) {
		this.mjuso2 = mjuso2;
	}


	public String getMemail2() {
		return memail2;
	}


	public void setMemail2(String memail2) {
		this.memail2 = memail2;
	}


	public String getMbirthyear() {
		return mbirthyear;
	}


	public void setMbirthyear(String mbirthyear) {
		this.mbirthyear = mbirthyear;
	}


	public String getMbirthmonth() {
		return mbirthmonth;
	}


	public void setMbirthmonth(String mbirthmonth) {
		this.mbirthmonth = mbirthmonth;
	}


	public String getMbirthday() {
		return mbirthday;
	}


	public void setMbirthday(String mbirthday) {
		this.mbirthday = mbirthday;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMpw() {
		return mpw;
	}


	public void setMpw(String mpw) {
		this.mpw = mpw;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getMphone() {
		return mphone;
	}


	public void setMphone(String mphone) {
		this.mphone = mphone;
	}


	public String getMjuso() {
		return mjuso;
	}


	public void setMjuso(String mjuso) {
		this.mjuso = mjuso;
	}


	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getMmen() {
		return mmen;
	}


	public void setMmen(String mmen) {
		this.mmen = mmen;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
    
	
    

}
