package kr.ac.kopo.sns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.sns.dao.MemberDao;
import kr.ac.kopo.sns.model.Member;

@Service
public class memberServiceImpl implements memberService {

	@Autowired
	MemberDao dao;


	@Override
	public void add(Member member) {
		dao.add(member);
	}

	@Override
	public Member loginList(Member member) {
		
		return dao.loginList(member);
	}

	@Override
	public List<Member> list() {
		return dao.list();
	}

	@Override
	public Member selectMember(Member vo) {
		return dao.selectMember(vo);
	}

	@Override
	public Member update(Member member) {
		return dao.update(member);
	}

	@Override
	public void delete(String member) {
		dao.delete(member);
	}


	@Override
	public int checkid(String memberId) {
		return dao.checkid(memberId);
	}














	
	
}
