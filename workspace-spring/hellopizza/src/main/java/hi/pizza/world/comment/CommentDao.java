package hi.pizza.world.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao 
{
	public int insertComment(CommentVo vo);
	public List<CommentVo> selectCommentList(int rpBbsid);
	
	int deleteComment(int rpId);
}
