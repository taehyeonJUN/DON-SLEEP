package kr.ac.kopo.sns.service;

import java.util.List;

import kr.ac.kopo.sns.model.Member;

public interface memberService {


	void add(Member member);


	Member loginList(Member member);


	List<Member> list();


	Member selectMember(Member vo);


	Member update(Member member);


	void delete(String member);


	int checkid(String memberId);

























}
