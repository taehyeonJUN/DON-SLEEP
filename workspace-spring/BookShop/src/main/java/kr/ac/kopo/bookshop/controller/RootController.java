package kr.ac.kopo.bookshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.service.CustomerService;

@Controller
public class RootController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	
	@ResponseBody //fail,ok의 메세지만 전송(jsp를 찾는게 아님 )
	@GetMapping("/checkID")
	String checkID(String id) {
		if(service.checkId(id)>0)
			return "FAIL";
	return "OK";
	}
	
	
	
	@GetMapping("/signup")
	String signup() {
		return "signup";
	}
	@PostMapping("/signup")
	String signup(Customer item) {
		service.add(item);
		
		return "redirect:/";
	}
	
	
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@PostMapping("/login")
	String login (Customer item, HttpSession session) {
		if(service.login(item)) {
			session.setAttribute("user", item);
			return "redirect:/";
	}
		return"login";
	}
	
	@RequestMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
		//  /를 하는 이유는 어디서든 로그인 고그아웃을 하기위하여
	}

}
