package hi.pizza.world.member;

public class MemberVo { //Vo�� DB�뿉�꽌 �뀒�씠釉붿쓽 �븳 �뻾�쓣 ���옣�븳�떎怨� 蹂대㈃�맂�떎.
	
	private String memId;
	private String memName;
	private String memPW;
	private String memPN;
	private String ROL;

	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPW() {
		return memPW;
	}
	public void setMemPW(String memPW) {
		this.memPW = memPW;
	}
	public String getMemPN() {
		return memPN;
	}
	public void setMemPN(String memPN) {
		this.memPN = memPN;
	}
	public String getROL() {
		return ROL;
	}
	public void setROL(String rOL) {
		ROL = rOL;
	}
	
}
