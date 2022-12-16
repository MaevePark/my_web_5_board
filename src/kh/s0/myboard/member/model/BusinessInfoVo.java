package kh.s0.myboard.member.model;

public class BusinessInfoVo {
//	BUSNO            NOT NULL VARCHAR2(30)  
//	BUSNAME          NOT NULL VARCHAR2(100) 
//	BUSCEONAME       NOT NULL VARCHAR2(100) 
//	BUSCERTIFICATION NOT NULL VARCHAR2(500) 
	private String busno;
	private String busname;
	private String busceoname;
	private String buscertification;
	@Override
	public String toString() {
		return "BusinessInfoVo [busno=" + busno + ", busname=" + busname + ", busceoname=" + busceoname
				+ ", buscertification=" + buscertification + "]";
	}
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public String getBusceoname() {
		return busceoname;
	}
	public void setBusceoname(String busceoname) {
		this.busceoname = busceoname;
	}
	public String getBuscertification() {
		return buscertification;
	}
	public void setBuscertification(String buscertification) {
		this.buscertification = buscertification;
	}
	
}
