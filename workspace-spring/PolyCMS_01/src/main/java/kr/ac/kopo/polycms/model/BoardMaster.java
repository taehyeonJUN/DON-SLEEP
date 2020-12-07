package kr.ac.kopo.polycms.model;

import java.util.Date;

public class BoardMaster {
	
	int boardId;
	String boardName;
	Date regDate;
	int attachType;
	int boardType;
	int replyType;
	int readPerm;
	int writePerm;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getAttachType() {
		return attachType;
	}
	public void setAttachType(int attachType) {
		this.attachType = attachType;
	}
	public int getBoardType() {
		return boardType;
	}
	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}
	public int getReplyType() {
		return replyType;
	}
	public void setReplyType(int replyType) {
		this.replyType = replyType;
	}
	public int getReadPerm() {
		return readPerm;
	}
	public void setReadPerm(int readPerm) {
		this.readPerm = readPerm;
	}
	public int getWritePerm() {
		return writePerm;
	}
	public void setWritePerm(int writePerm) {
		this.writePerm = writePerm;
	}
	
}
