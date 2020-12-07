package kr.ac.kopo.sns.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.sns.model.Member;

@Repository
public class memberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sql;

	@Override
	public void add(Member member) {
		sql.insert("member.add",member);
	}

	@Override
	public Member loginList(Member member) {
		return sql.selectOne("member.loginList", member);		
	}

	@Override
	public List<Member> list() {
		return sql.selectList("member.list");
	}

	@Override
	public Member selectMember(Member vo) {
		return sql.selectOne("member.selectList", vo);
	}

	@Override
	public Member update(Member member) {
		return sql.selectOne("member.update",member);
	}

	@Override
	public void delete(String member) {
		sql.delete("member.delete",member);
	}

	@Override
	public int checkid(String memberId) {
		return sql.selectOne("member.checkId", memberId);
	}




}
