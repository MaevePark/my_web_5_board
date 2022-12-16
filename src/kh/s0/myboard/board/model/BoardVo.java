package kh.s0.myboard.board.model;

import java.sql.Timestamp;
import java.util.List;

public class BoardVo {
//	BNO      NOT NULL NUMBER         
//	BTITLE   NOT NULL VARCHAR2(300)  
//	BCONTENT NOT NULL VARCHAR2(4000) 
//	BDATE    NOT NULL TIMESTAMP(6)   
//	BCNT     NOT NULL NUMBER         
//	BREF     NOT NULL NUMBER         
//	BRELEVEL NOT NULL NUMBER         
//	BRESTEP  NOT NULL NUMBER         
//	BWRITER  NOT NULL VARCHAR2(30)   
//	BTYPE    NOT NULL CHAR(1)   
	
//	<List>
//	BFILEPATH NOT NULL VARCHAR2(500) 
//	BNO       NOT NULL NUMBER    
	
	private int bno;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bcnt;
	private int bref;
	private int brelevel;
	private int brestep;
	private String bwriter;
	private String btype;
	
// bfile 테이블에 대한 방법 1
	private List<BoardFileVo> bfilelist;
// bfile 테이블에 대한 방법 2
//		private List<String> bfilepathlist;
	
	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate=" + bdate + ", bcnt="
				+ bcnt + ", bref=" + bref + ", brelevel=" + brelevel + ", brestep=" + brestep + ", bwriter=" + bwriter
				+ ", btype=" + btype + ", bfilelist=" + bfilelist + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public Timestamp getBdate() {
		return bdate;
	}

	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}

	public int getBcnt() {
		return bcnt;
	}

	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}

	public int getBref() {
		return bref;
	}

	public void setBref(int bref) {
		this.bref = bref;
	}

	public int getBrelevel() {
		return brelevel;
	}

	public void setBrelevel(int brelevel) {
		this.brelevel = brelevel;
	}

	public int getBrestep() {
		return brestep;
	}

	public void setBrestep(int brestep) {
		this.brestep = brestep;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public List<BoardFileVo> getBfilelist() {
		return bfilelist;
	}

	public void setBfilelist(List<BoardFileVo> bfilelist) {
		this.bfilelist = bfilelist;
	}
	
	
	
	
}
















