package kr.ac.kopo.bbs0612;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachDao {
	public int insertAttach(AttachVo vo);

	public AttachVo selectAttach(int attNo);

}
