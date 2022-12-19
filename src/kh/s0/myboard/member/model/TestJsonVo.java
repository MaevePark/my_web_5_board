package kh.s0.myboard.member.model;

public class TestJsonVo {
	private String pno;
	private String amount;
	@Override
	public String toString() {
		return "TestJsonVo [pno=" + pno + ", amount=" + amount + "]";
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
