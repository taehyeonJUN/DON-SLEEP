package kr.ac.kopo.sns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

import kr.ac.kopo.sns.model.Member;
import kr.ac.kopo.sns.model.Post;
import kr.ac.kopo.sns.model.Rp;
import kr.ac.kopo.sns.model.RpInfo;
import kr.ac.kopo.sns.service.PostService;
import kr.ac.kopo.sns.service.rpService;

@Controller
@RequestMapping("/rp")
public class RpController {
	final String path="rp/";
	@Autowired
	rpService service;
	
	@Autowired
	PostService poservice;
	
	@ResponseBody
	@PostMapping("/add")
	public String add(@RequestBody Rp rp, HttpSession session){
		// 로그인한 사용자의 아이디를 게시글 작성자로 강제 설정
		Member member = (Member) session.getAttribute("user");
		rp.setRpId(member.getMemId());
//		System.out.println(rp.getRpId()+"--------------");
		
		int check = service.add(rp);
		int ch = poservice.RpAmount(rp.getRpPostNo());
//		session.setAttribute("result", check);
		JSONObject obj = new JSONObject();
		obj.put("ch", ch);
		
		return obj.toJSONString();
	}
	
	// 선택한 게시글만 조회 url명 혿동주의
	@ResponseBody
	@PostMapping("/rpList")
	RpInfo rpList(@RequestBody Rp rpPostNo) {
//		List<Rp> list=service.selectList(rpPostNo);
//		model.addAttribute("list", list);
		
		
		JSONObject obj = new JSONObject();
		RpInfo info = new RpInfo();
		info.setList(service.selectList(rpPostNo));
		
		return info;
	}
	
	
//	
//	// 선택한 게시글만 조회 url명 혿동주의
//	@GetMapping("/rpList")
//	String rpList(@PathVariable int rpPostNo, Model model) {
//		List<Rp> list=service.selectList(rpPostNo);
//		model.addAttribute("rpList", list);
//		
//		
//		return path+"rplist";
//	}
	
	
	
	
	
	@ResponseBody
	@DeleteMapping
	String delete(@RequestBody Rp rpNo) {
		
		service.delete(rpNo);
		int ch = poservice.RpAmount(rpNo.getRpPostNo());
		JSONObject obj = new JSONObject();
		obj.put("ch", ch);
		
		return obj.toJSONString();
		}
	
	@RequestMapping("/update")
	@ResponseBody
	String update(int rpNo, Model model){
		System.out.println("update문@@@");
		service.read(rpNo);
//		upcheck 에 변수에 getrpNo담기
		if(1>0) 
			return "TRUE";
		else 
			return "FALSE";
	}
	
//	@RequestMapping("/checkRp")
//	String checkRp(Model model, ) {
//		
//	}
	
	@ResponseBody
	@RequestMapping(value="/rpEditForm" ,method = RequestMethod.POST)
	Rp rpEditForm(@RequestBody Rp rpNo) {
		Rp rp=service.rpEditForm(rpNo);
		JSONObject obj = new JSONObject();
		obj.put("rp", rp);
		return rp;
	}
	
	@ResponseBody
	@PatchMapping
	private void edit(@RequestBody Rp rp) {
		service.edit(rp);
	}
	
	
}
