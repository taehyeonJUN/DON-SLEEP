package kr.ac.kopo.bbs0612;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BbsVo { //게시글 하나를 저장할 수 있는 클래스

	  private int bbsNo;
	  private String bbsWriter;
	  private String bbsTitle;
	  private String bbsContent;
	  private Date bbsRegDate;
	  private int bbsCount;
	   
	  //첨부파일 정보를 담는 필드
	   private List<MultipartFile> upfileList;
	   
	   public List<AttachVo> getAttachList() {
		return attachList;
	}
	public void setAttachList(List<AttachVo> attachList) {
		this.attachList = attachList;
	}
	
	private List<AttachVo> attachList;
	   
	   //스프링의 MultipartResolver를 통해서 업로드된 파일을 받을 때는 
	   //하나의 파일이 하나의 MultipartFile객체로 받는다 
	   public List<MultipartFile> getUpfileList() {
		return upfileList;
	}
	public void setUpfileList(List<MultipartFile> upfileList) {
		this.upfileList = upfileList;
	}
	//////////////////////////////////////
	   public String getBbsWriter() {
		   return bbsWriter;
	   }
	   public void setBbsWriter(String bbsWriter) {
		   this.bbsWriter = bbsWriter;
	   }
	   public int getBbsNo() {
	      return bbsNo;
	   }
	   public void setBbsNo(int bbsNo) {
	      this.bbsNo = bbsNo;
	   }
	   public String getBbsTitle() {
	      return bbsTitle;
	   }
	   public void setBbsTitle(String bbsTitle) {
	      this.bbsTitle = bbsTitle;
	   }
	   public String getBbsContent() {
	      return bbsContent;
	   }
	   public void setBbsContent(String bbsContent) {
	      this.bbsContent = bbsContent;
	   }
	   public Date getBbsRegDate() {
	      return bbsRegDate;
	   }
	   public void setBbsRegDate(Date bbsRegDate) {
	      this.bbsRegDate = bbsRegDate;
	   }
	   public int getBbsCount() {
	      return bbsCount;
	   }
	   public void setBbsCount(int bbsCount) {
	      this.bbsCount = bbsCount;
	   }
	
	
		
	

}
