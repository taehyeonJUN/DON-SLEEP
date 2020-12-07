package kr.ac.kopo.reply;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{
	@Resource
	private ReplyDao replyDao;
	
	@Override
	public int insertReply(ReplyVo vo) {
		
		return replyDao.insertReply(vo);
	}

	@Override
	public List<ReplyVo> selectList(int bbsNo) {
		
		return replyDao.selectList(bbsNo);
	}

}
