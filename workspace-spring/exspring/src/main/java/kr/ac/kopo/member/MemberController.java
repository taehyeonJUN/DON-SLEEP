package kr.ac.kopo.member;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.comm.PageInfo;
import kr.ac.kopo.comm.SearchInfo;


@Controller("/member/list.do") //
public class MemberController {
	//	@Autowired, @Inject, @Resource 중 하나를 사용해 스프링에 등록된 객체를 주입
	@Resource(name="memberService") //이름은 안써도 됨
	private MemberService memberService;
	//서블릿이 만들어질때 한번만 실행

	//@RequestMapping(value ="/member/list.do", method = RequestMethod.GET)
	@RequestMapping(value ="/member/list.do")
	public String list(Map modelMap, SearchInfo info) {
		int num=memberService.selectCount(info);
		info.setTotalRecordCount(num);
		info.renderHTML();
		List<MemberVo> list = memberService.selectMemberList(info);


		modelMap.put("memList", list);//모델에 데이터 저장 memList라는이름으로 저장

		//		/exweb/WebContent/WEB-INF/views/member0603/MemList0603.jsp
		//		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/member0603/MemList0603.jsp");//현재 요청을 위임하여 처리할 수 있게하는 디스패쳐 가져오기
		//		rd.forward(req, resp);//현재 요청객체와 응답객체를 전달해 주면서 이동 
		//실행합과 동시에 jsp로 이동

		//req.getRequestDispatcher("/WEB-INF/jsp/member0603/MemList0603.jsp").forward(req, resp);
		return "member0603/MemList0603";
	}
	
	
	
//	111111111111111111111111111111111111111
	@RequestMapping(value ="/member/add.do",method = RequestMethod.GET )
	public String addform(MemberVo vo){ //필요없지만, jsp의 스프링 폼 태그에서 모델객체로 지정되어 있어서 MemberVo인자 추가
		return "member0603/MemAddForm";
	}

	@RequestMapping(value ="/member/add.do",method = RequestMethod.POST)
	

	public String add(@Valid MemberVo vo,	//스프링 객체의 검증을 적용하고 싶은 인자 앞에 @Valid적용
			BindingResult result) {//검증결과를 받기 위해서, 다음인자로 BindingResult 또는 Error타입의 인자를 추가
			if(result.hasErrors()) {
				System.out.println("검증실패");
				return "member0603/MemAddForm";
			}else {
				System.out.println("검증 성공");
			}
		
		int num = memberService.insertMember(vo);
		System.out.println(num+"개의 정보 추가");

		//컨트롤러에서 반환하는 뷰 이름 문자열의 앞에 "redirect:"을 붙여서 리다이렉트 표시
		return "redirect:/member/list.do";

	}

	@RequestMapping(value ="/member/edit.do",method = RequestMethod.GET )
	public String esitfrom(String memId, Map modelMap){

		//String no = req.getParameter("memId");
		MemberVo vo = memberService.selectMember(memId);
		//req.setAttribute("memVo", vo);//(요청 객체에 객체 저장해서 jsp에서 꺼내 씀)
		modelMap.put("memVo", vo);
		//req.getRequestDispatcher("/WEB-INF/views/member0603/MemEditForm.jsp").forward(req, resp);
		return "member0603/MemEditForm";

	}


	@RequestMapping(value ="/member/edit.do",method = RequestMethod.POST)
	public String edit(MemberVo vo){

		//req.setCharacterEncoding("UTF-8");

		//		MemberVo vo=new MemberVo();
		//		vo.setMemId(req.getParameter("memId"));
		//		vo.setMemName(req.getParameter("memName"));
		//		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));

		int num = memberService.updateMember(vo);
		System.out.println(num+"개의 정보가 변경");


		return "redirect:/member/list.do";


	}

	@RequestMapping(value = "/member/del.do")
	public String del(String memId){


		//		req.setCharacterEncoding("UTF-8");
		//		String memId = req.getParameter("memId");
		int num = memberService.deleteMember(memId);
		System.out.println(num+"개의 데이터를 삭제");
		return "redirect:/member/list.do";
	}


	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public String loginForm(){
		return "member0603/Login";
	}

	
	
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String login(MemberVo vo, HttpSession session){
//		HttpServletRequest,HttpServletResponse,HttpSession 객체가 필요한 경우, 컨트롤러 메서드의 파라미터로 지정하면 스프링이 전달해줌.
		MemberVo log=memberService.selectLoginMember(vo);
		
		//로그인 성공시, 회원목록이나 게시판으로 이동
		//PrintWriter out=resp.getWriter();
		if(log==null) { //로그인 실패(입력한 id/pw와 일치하는 회원이 없는 경우)
			//out.print("fail");
			return "redirect:/member/login.do";
	
		}else {
			//out.print("login");
			session.setAttribute("loginUser", log); // 로그인한 사람의 정보가 담긴 객체를 loginUser라는 이름의 세션에 저장
			return "redirect:/member/list.do";
		}
		
			
			
		}
		
		@RequestMapping(value ="/member.logout.do",method = RequestMethod.GET)
		public String logout(HttpSession session){
		
//			session.setAttribute("loginUser", null); // 세션에 loginUser라는 이름으로 null 저장
//			session.removeAttribute("loginUser"); // 세션에 loginUser라는 이름으로 저장한 값 제거
			session.invalidate(); // 세션 자체를 초기화 // 새로생성 = 세션에 저장했던 모든 데이터 삭제
			return "redirect:/member/login.do";
}



}
