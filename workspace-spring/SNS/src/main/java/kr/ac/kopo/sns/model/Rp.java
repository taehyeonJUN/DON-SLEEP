package kr.ac.kopo.sns.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Rp {
	int rpNo;
	String rpContent;
	//Jacson 라이브러리가 JSON으로 변환시 지정한 패턴에 맞는 문자열로 변환하도록 지정
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	Date rpDate;
	int rpPostNo;
	String rpId;
	
	
	public int getRpNo() {
		return rpNo;
	}
	public void setRpNo(int rpNo) {
		this.rpNo = rpNo;
	}
	public String getRpContent() {
		return rpContent;
	}
	public void setRpContent(String rpContent) {
		this.rpContent = rpContent;
	}
	public Date getRpDate() {
		return rpDate;
	}
	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}
	public int getRpPostNo() {
		return rpPostNo;
	}
	public void setRpPostNo(int rpPostNo) {
		this.rpPostNo = rpPostNo;
	}
	public String getRpId() {
		return rpId;
	}
	public void setRpId(String rpId) {
		this.rpId = rpId;
	}
	
	
}
