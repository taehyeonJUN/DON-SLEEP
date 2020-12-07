package kr.ac.kopo.reply;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyVo {
	private int repNo; 
	private String repContent; 
	private String repWriter;
	
	//Jackson 라이브러리가 제이슨으로 변환시 지정한 패턴에 맞는 문자열로 변환하도록 지정
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy년 MM월 dd일 hh:mm:ss", timezone="Asia/Seoul")
	private Date repDate; 
	private int repBbsNo;
	public int getRepNo() {
		return repNo;
	}
	public void setRepNo(int repNo) {
		this.repNo = repNo;
	}
	public String getRepContent() {
		return repContent;
	}
	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}
	public String getRepWriter() {
		return repWriter;
	}
	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	public int getRepBbsNo() {
		return repBbsNo;
	}
	public void setRepBbsNo(int repBbsNo) {
		this.repBbsNo = repBbsNo;
	}
	
	
}
