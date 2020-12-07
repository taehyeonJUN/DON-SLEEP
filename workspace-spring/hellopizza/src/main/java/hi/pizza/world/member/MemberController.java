package hi.pizza.world.member;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hi.pizza.world.comm.SearchInfo;

@Controller
public class MemberController{

	//	@Autowired,@Inject, @Resource 중 하나를 사용하여 스프링에 등록된 객체를 주입
	@Resource(name ="memberService")
	private MemberService memberService; 

	
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	
	protected String homeform(){
		return "comm/homeForm";
	}

	@RequestMapping(value = "/member/list.do")

	public String list(Map modeMap, SearchInfo searchInfo){
		int num = memberService.selectCount(searchInfo);
		searchInfo.setTotalRecordCount(num);
		searchInfo.remderHTML();
		
		List<MemberVo> list = memberService.selectMemberList(searchInfo);
		
		modeMap.put("memList", list); 
		
		return "member/memList";
	}

	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)

	protected String addform(){
		return "member/memAddForm";
	}


	@RequestMapping(value = "/member/add.do", method = RequestMethod.POST)
	public String add(MemberVo vo){
		System.out.println("...");
		
		int num = memberService.insertMember(vo);
		System.out.println(num + "개의 레코드 추가");

		return "redirect:/home.do";

	}

	@RequestMapping(value = "/member/edit.do", method = RequestMethod.GET)
	public String editform(String memId,Map modelMap){
		MemberVo vo = memberService.selectMember(memId);
		modelMap.put("memVo", vo);
		return "member/memEditForm";
	}

	@RequestMapping(value = "/member/edit.do", method = RequestMethod.POST)
	public String edit( MemberVo vo){

		int num = memberService.updateMember(vo);
		System.out.println(num+"개의 레코드 변경");

		return "redirect:/member/list.do";
	}

	@RequestMapping("/member/del.do")
	public String del(String memId) {
		int num = memberService.deleteMember(memId);
		System.out.println(num+"개의 데이터를 삭제");
		return "redirect:/member/list.do";

	}

	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public String loginform(){
		return "member/loginList";
	}

	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String login(MemberVo vo,HttpSession session){ 
		MemberVo loginVo = memberService.selectLoginMember(vo);

		if(loginVo==null) { // 로그인 실패(입력한 ID/PW와 일치하는 회원이 없는 경우)
			return "redirect:/member/login.do";
		}else { // 로그인성공(입력한 ID/PW와 일치하는 회원이 있는 경우)
			session.setAttribute("loginUser", loginVo);
			return "redirect:/home.do";
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		}
	}

	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public String loginout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/member/list.do";
	}
	

}
