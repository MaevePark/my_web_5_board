package kh.s0.myboard.member.model;

import java.sql.Date;  // 중요 

public class MemberVo {
//	MID       NOT NULL VARCHAR2(30)  
//	MPWD      NOT NULL VARCHAR2(20)  
//	MNAME     NOT NULL VARCHAR2(100) 
//	MEMAIL    NOT NULL VARCHAR2(100) 
//	MENTRANCE NOT NULL DATE          
//	MAUTHCODE NOT NULL VARCHAR2(20)  
//	MCONSENT1 NOT NULL NUMBER(3)     
//	MTYPE     NOT NULL NUMBER(1)     
//	BUSNO              VARCHAR2(30)  
	private String mid;
	private String mpwd;
	private String mname;
	private String memail;
	private Date mentrance;
	private String mauthcode;
	private int mconsent1;
	private int mtype;
	// BusinessInfoVo 사용하지 않고 분리해서 사용
	private String busno;
	
	public MemberVo() {
		super();
	}
	@Override
	public String toString() {
		return "MemberVo [mid=" + mid + ", mpwd=" + mpwd + ", mname=" + mname + ", memail=" + memail + ", mentrance="
				+ mentrance + ", mauthcode=" + mauthcode + ", mconsent1=" + mconsent1 + ", mtype=" + mtype + ", busno="
				+ busno + "]";
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public Date getMentrance() {
		return mentrance;
	}
	public void setMentrance(Date mentrance) {
		this.mentrance = mentrance;
	}
	public String getMauthcode() {
		return mauthcode;
	}
	public void setMauthcode(String mauthcode) {
		this.mauthcode = mauthcode;
	}
	public int getMconsent1() {
		return mconsent1;
	}
	public void setMconsent1(int mconsent1) {
		this.mconsent1 = mconsent1;
	}
	public int getMtype() {
		return mtype;
	}
	public void setMtype(int mtype) {
		this.mtype = mtype;
	}
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}


	
}
