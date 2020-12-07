package hi.pizza.world.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hi.pizza.world.member.MemberVo;


@Controller
public class CommentController 
{
	@Resource
	private CommentService commentService;
	
	@RequestMapping("/comment/add.do")
	@ResponseBody
	public Map<String, Object> add(CommentVo vo, HttpSession session)
	{
		MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");
		vo.setRpUser(loginVo.getMemId());
		int num = commentService.insertComment(vo);
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", num);
		
		return map;
	}
	
	@RequestMapping("/comment/list.do")
	@ResponseBody
	public List<CommentVo> list(int rpBbsid)
	{
		List<CommentVo> commentList = commentService.selectCommentList(rpBbsid);
		return commentList;
	}
	
	@RequestMapping("/comment/del.do")
	@ResponseBody
	//public Map<String, Object> del(int rpId)
	public Map<String, Object> del(CommentVo vo, HttpSession session)
	{
		int num = commentService.deleteComment(vo.getRpId());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", num);
		
		return map;
	}
	
}
