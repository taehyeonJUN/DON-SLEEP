package kr.ac.kopo.reply;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyDao {
	public int insertReply(ReplyVo vo);
	public List<ReplyVo> selectList(int bbsNo);
	
}
