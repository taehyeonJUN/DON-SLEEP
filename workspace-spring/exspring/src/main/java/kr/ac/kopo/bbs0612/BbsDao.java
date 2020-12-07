package kr.ac.kopo.bbs0612;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsDao {

	List<BbsVo> selectBbsList();

	BbsVo selectBbs(int bbsNo);

	int insertBbs(BbsVo Vo);

	int updateBbs(BbsVo vo);

	int deleteBbs(int bbsNo);

}