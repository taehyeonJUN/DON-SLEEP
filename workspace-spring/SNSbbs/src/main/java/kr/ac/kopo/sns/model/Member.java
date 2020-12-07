package kr.ac.kopo.sns.model;

import java.util.Date;

public class Member {
	String memId;
	String memPass;
	String memName;
	String memTel;
	Date memDate;
	String memAuthor;
	String memIntro;
	int memFollow;
	int memFollower;
	
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public Date getMemDate() {
		return memDate;
	}

	public void setMemDate(Date memDate) {
		this.memDate = memDate;
	}

	public String getMemAuthor() {
		return memAuthor;
	}

	public void setMemAuthor(String memAuthor) {
		this.memAuthor = memAuthor;
	}

	public String getMemIntro() {
		return memIntro;
	}

	public void setMemIntro(String memIntro) {
		this.memIntro = memIntro;
	}

	public int getMemFollow() {
		return memFollow;
	}

	public void setMemFollow(int memFollow) {
		this.memFollow = memFollow;
	}

	public int getMemFollower() {
		return memFollower;
	}

	public void setMemFollower(int memFollower) {
		this.memFollower = memFollower;
	}

}
