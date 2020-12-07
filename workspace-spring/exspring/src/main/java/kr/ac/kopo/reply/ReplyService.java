package kr.ac.kopo.reply;

import java.util.List;

public interface ReplyService {
	public int insertReply(ReplyVo vo);
	public List<ReplyVo> selectList(int bbsNo);
	
}
