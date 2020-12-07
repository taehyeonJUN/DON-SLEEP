package kr.ac.kopo.sns.model;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Post {
	int postNo;
	String postId;
	String postContent;
	int postLike;
	Date postDate;
	List<MultipartFile> upfileList;  //첨부파일 정보를 담는 필드
	List<Photo> attachList;
	
	//로그인 멤버의 좋아요 여부
	int likeCheck;
	
	//포스트 개별 좋아요 좋아요 취소 여부
	int ch;
	
	//댓글 갯수 체크
	int RpAmount;
	
	
	

	public int getRpAmount() {
		return RpAmount;
	}
	public void setRpAmount(int rpAmount) {
		RpAmount = rpAmount;
	}
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	public int getLikeCheck() {
		return likeCheck;
	}
	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}
	public List<Photo> getAttachList() {
		return attachList;
	}
	public void setAttachList(List<Photo> attachList) {
		this.attachList = attachList;
	}
	public List<MultipartFile> getUpfileList() {
		return upfileList;
	}
	public void setUpfileList(List<MultipartFile> upfileList) {
		this.upfileList = upfileList;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public int getPostLike() {
		return postLike;
	}
	public void setPostLike(int postLike) {
		this.postLike = postLike;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	

}
