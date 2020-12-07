package kr.ac.kopo.reply;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.member.MemberVo;

@Controller
public class ReplyController {
	
	@Resource
	private ReplyService replyService;

	@RequestMapping("/reply/add.do")
	@ResponseBody
	public HashMap<String,Object> add(ReplyVo vo, HttpSession session)  {
		 // 로그인한 사용자의 아이디를 게시글 작성자로 강제 설정
		MemberVo loginVo=(MemberVo) session.getAttribute("loginUser");
		vo.setRepWriter(loginVo.getMemId());
		
	int num= replyService.insertReply(vo);
	
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("result", num);
	
	return map;
}
	
	@RequestMapping("/reply/list.do")
	@ResponseBody
	public List<ReplyVo> list(int repBbsNo) {
		List<ReplyVo> replyList=replyService.selectList(repBbsNo);
		return replyList;
	
	}
	
}
