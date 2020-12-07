package kr.ac.kopo.member;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.kopo.comm.PageInfo;
import kr.ac.kopo.comm.SearchInfo;


//<mybatis-spring:scan>에 의해서 자동으로 구현체를 생성해야하는 인터페이스임을 표시하기 위해 @Mapper 어노테이션 사용
@Mapper
public interface MemberDao {

	int selectCount(SearchInfo info);

	List<MemberVo> selectMemberList(SearchInfo info);

	MemberVo selectMember(String memId);

	int insertMember(MemberVo Vo);

	int updateMember(MemberVo vo);

	int deleteMember(String memId);

	MemberVo selectLoginMember(MemberVo memVo);

}