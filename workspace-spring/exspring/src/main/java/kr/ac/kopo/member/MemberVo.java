package kr.ac.kopo.member;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.aspectj.lang.annotation.Pointcut;

//�Ϲ������� ������ ���̽� ���̺��� ���ڵ�(row)1���� ������ �� �ִ� voŬ������ ����

public class MemberVo {
	@NotEmpty //null 또는 빈 문자열 저장 금지
	@Size(min=2, max=50) //문자열 길이가 1~50사이
	private String memId;
	@NotEmpty //null 또는 빈 문자열 저장 금지
	@Size(min=2, max=50) //문자열 길이가 1~50사이
	private String memPass;
	
	@NotEmpty @Size(min=2, max=10)
	private String memName;
	@Min(0) //0값 이상만 가능
	private int memPoint;
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
	public int getMemPoint() {
		return memPoint;
	}
	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}

}
