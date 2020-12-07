package kr.ac.kopo.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.ac.kopo.comm.PageInfo;
import kr.ac.kopo.comm.SearchInfo;

//싱글톤 패턴
//애플리케이션 전체에서 객체를 한개만 만들어서 여러곳에서 함께 사용

//이 객체를 서비스 역할을 하는 객체로서 스프링에 memberService라는 이름으로 등록
@Service("memberService") //첫글자만 소문자
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberDao")
	private MemberDao memberDao;


	@Override
	public List<MemberVo> selectMemberList(SearchInfo info) {

		return memberDao.selectMemberList(info);

	}

	@Override
	public MemberVo selectMember(String memId) {

		return memberDao.selectMember(memId);
	}

	@Override
	public int insertMember(MemberVo Vo) {

		return memberDao.insertMember(Vo);
	}

	@Override
	public int updateMember(MemberVo vo) {

		return memberDao.updateMember(vo);
	}

	@Override
	public int deleteMember(String memId) {

		return memberDao.deleteMember(memId);
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memVo) {

		return memberDao.selectLoginMember(memVo);
	}

	@Override
	public int selectCount(SearchInfo info) {
		
		return memberDao.selectCount(info);
	}



}
