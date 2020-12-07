package hi.pizza.world.comment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService
{
	@Resource
	private CommentDao commentDao;
	
	@Override
	public int insertComment(CommentVo vo) 
	{
		return commentDao.insertComment(vo);
	}

	@Override
	public List<CommentVo> selectCommentList(int rpBbsid) 
	{
		return commentDao.selectCommentList(rpBbsid);
	}

	@Override
	public int deleteComment(int rpId) 
	{
		return commentDao.deleteComment(rpId);
	}

}
