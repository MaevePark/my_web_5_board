package kh.s0.myboard.board.model;

public class BoardFileVo {
//	BFILEPATH NOT NULL VARCHAR2(500) 
//	BNO       NOT NULL NUMBER    
	private String bfilepath;
	private int bno;
	@Override
	public String toString() {
		return "BoardFileVo [bfilepath=" + bfilepath + ", bno=" + bno + "]";
	}
	public String getBfilepath() {
		return bfilepath;
	}
	public void setBfilepath(String bfilepath) {
		this.bfilepath = bfilepath;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
}
