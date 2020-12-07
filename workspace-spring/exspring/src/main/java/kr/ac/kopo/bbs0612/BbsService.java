package kr.ac.kopo.bbs0612;

import java.io.File;
import java.util.List;

public interface BbsService {

	List<BbsVo> selectBbsList();

	BbsVo selectBbs(int bbsNo);

	int insertBbs(BbsVo Vo);

	int updateBbs(BbsVo vo);

	int deleteBbs(int bbsNo);

	AttachVo selectAttach(int attNo);

	File getAttachFile(AttachVo vo);

	 

}