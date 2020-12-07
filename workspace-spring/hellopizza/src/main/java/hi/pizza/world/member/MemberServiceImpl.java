package hi.pizza.world.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hi.pizza.world.comm.SearchInfo;

//�떛湲��넠(Singleton) �뙣�꽩 :
// �븷�뵆由ъ��씠�뀡 �쟾泥댁뿉�꽌 媛앹껜(�씤�뒪�꽩�뒪)瑜� "1媛쒕쭔" 留뚮뱾�뼱�꽌 �뿬�윭怨녹뿉�꽌 �븿猿� �궗�슜

// �씠 媛앹껜瑜� �꽌鍮꾩뒪�뿭�븷�쓣 �븯�뒗 媛앹껜濡쒖꽌  MemberService �씪�뒗 �씠由꾩쑝濡� �뒪�봽留곸뿉 �벑濡�
@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name = "memberDao")
	private MemberDao memberDao;
	
	@Override
	public List<MemberVo> selectMemberList(SearchInfo searchInfo) {
		return memberDao.selectMemberList(searchInfo);
	}

	@Override
	public MemberVo selectMember(String memId) {
		return memberDao.selectMember(memId);
	}

	@Override
	public int insertMember(MemberVo vo) {
		return memberDao.insertMember(vo);
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
	public MemberVo selectLoginMember(MemberVo memberVo) {
		return memberDao.selectLoginMember(memberVo);
	}

	@Override
	public int selectCount(SearchInfo searchInfo) {
		return memberDao.selectCount(searchInfo);
	}
}
