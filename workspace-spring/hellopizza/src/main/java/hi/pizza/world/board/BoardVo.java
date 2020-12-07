package hi.pizza.world.board;

import java.util.Date;

public class BoardVo 
{
	private int bbsId;
	private String bbsUser;
	private String bbsTitle;
	private String bbsText;
	private Date bbsDate;
	
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public String getBbsUser() {
		return bbsUser;
	}
	public void setBbsUser(String bbsUser) {
		this.bbsUser = bbsUser;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsText() {
		return bbsText;
	}
	public void setBbsText(String bbsText) {
		this.bbsText = bbsText;
	}
	public Date getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(Date bbsDate) {
		this.bbsDate = bbsDate;
	}
}
