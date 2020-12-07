package kr.ac.kopo.sns.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.sns.model.Member;
import kr.ac.kopo.sns.service.memberService;


@Controller
public class RootController {
   @Autowired
   memberService service;
   
   @RequestMapping("/")
   String index() {
      
      return "login";
   }
   
   @ResponseBody
   @GetMapping("/checkId") 
   String checkid(String memberId){
      System.out.println("checkId매핑@");
      
      if(service.checkid(memberId) > 0) {
         return "FALSE";
      }else {
         return "TRUE";
      }
      }
   
   
   // 회원가입 !!! 
   @GetMapping("/register")
   String register() {
      return "register";
   }
   
   @PostMapping("/register")
   String register(Member info) {
      service.add(info);
      
      return "redirect:login";  // login전에 / 붙여야될수도?
   }
   
   
   @GetMapping("/login")
   String login() {
      return "login";
   }

   @PostMapping("/login")
    String login(Member member,HttpSession session) {
      Member info = service.loginList(member);
      
      if(info==null) {
         return "login";
      }else {
         session.setAttribute("user", info);
         return "redirect:/post/list";
         
      }
         
   }
      
   @RequestMapping("/logout")
   String logout(HttpSession session) {
      
      session.invalidate();
      
      return "login";
   }
   
}