package hi.pizza.world.member;

//import java.util.ArrayList;
import java.util.List;

import hi.pizza.world.comm.SearchInfo;

public interface MemberService {

	List<MemberVo> selectMemberList(SearchInfo searchInfo);

	MemberVo selectMember(String memId);

	int insertMember(MemberVo vo);

	int updateMember(MemberVo vo);

	int deleteMember(String memId);

	MemberVo selectLoginMember(MemberVo memVo);

	int selectCount(SearchInfo searchInfo);

}