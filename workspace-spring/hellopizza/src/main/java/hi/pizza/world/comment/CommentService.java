package hi.pizza.world.comment;

import java.util.List;

public interface CommentService 
{
	public int insertComment(CommentVo vo);
	public List<CommentVo> selectCommentList(int rpBbsid);
	
	int deleteComment(int rpId);
}
