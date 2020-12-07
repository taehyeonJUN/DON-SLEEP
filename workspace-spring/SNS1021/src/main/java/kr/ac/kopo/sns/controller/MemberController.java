package kr.ac.kopo.sns.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.sns.model.Member;
import kr.ac.kopo.sns.service.memberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	final String path = "member/";
	
	
	@Autowired
	memberService service;

	
	@RequestMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Member member) {
		
			service.add(member);
			
			return "redirect:/login";

	}
		
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	   public String list(Model model) {
	      List<Member> list = service.list();
	      
	      System.out.println(list.toString()+"*******************");
	      
	      model.addAttribute("memList",list);
	      
	      return path + "list";
	}

	
	// update문임!!
	@GetMapping("/select")
	String select(Model model, HttpSession session) {
		Member vo = (Member) session.getAttribute("user");
		
		Member x = service.selectMember(vo);
		
		System.out.println("***selectGet***x값"+x);
		System.out.println("*******권한****x값"+x.getMemAuthor());
		
		model.addAttribute("memberList",x);
		
		return path + "selectList";
	}
	
	// update문임!!
	@PostMapping("/select")
	String select(Member member, HttpSession session) {
		
		Member x = (Member) session.getAttribute("user");
		
		service.update(member);
		
		session.setAttribute("user", x);
		
		return "redirect:/";
	}
	
	// String으로도 PathVariable이 가능하다는걸 알게됐음 !
	@RequestMapping("{memId}/delete")
	String delete(@PathVariable("memId") String member) {
		//pathVariable은 jsp에서 가져온 값을 넣음으로써 그 값을 이용하여 service처리를 한다.
		service.delete(member);
		
		return "redirect:/login";
	}
	

	
	
	
}
