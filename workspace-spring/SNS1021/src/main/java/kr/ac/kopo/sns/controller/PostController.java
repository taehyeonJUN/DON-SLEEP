package kr.ac.kopo.sns.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.sns.model.Member;
import kr.ac.kopo.sns.model.Post;
import kr.ac.kopo.sns.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService service;
	
	final String path="post/";
	private String uploadPath="d://SNS_Photo/";
	
	//게시글 조회  조회조건 : 작성자 본인, 팔로우한 친구들의 글 조회 가능
	@GetMapping("list")
	String list(Model model,Post vo ,HttpSession session){
		
		//로그인한 유저의 정보를 가져와서 게시글 작성자에 반영함
		Member member= (Member)session.getAttribute("user");
		vo.setPostId(member.getMemId());
		
		List<Post> list = service.list(vo);
		
		int ch=0;
		
		
		for (int i = 0; i < list.size(); i++) {
			int poNo=list.get(i).getPostNo();
			int like = service.checkLike(poNo);
			String no=null;
			
			//게시글의좋아요 수 체크
			list.get(i).setPostLike(like);
			
			no=list.get(i).getPostId();
			//post2.setPost를 하면 리스트에 담긴 아이디도 바뀌어 임시방편으로 변수에 임시 저장
			
			Post post2=list.get(i);
			
			post2.setPostId(member.getMemId());
			//로그인 사용자의 좋아요 여부체크
			//세션 아이디 넣고 
			ch= service.like_check(post2);
			
			
			list.get(i).setLikeCheck(ch);
			list.get(i).setPostId(no);
		}
		
		model.addAttribute("list",list);
		
		return path + "list";
	}
	
	//게시글 작성 폼으로 이동
	@GetMapping("/add")
	String addForm() {
		return path + "add";
	}
	
	//작성된 게시글 게시
	@PostMapping("/add")
	String add(Post vo, HttpSession session) {
		
		Member member= (Member)session.getAttribute("user");
		vo.setPostId(member.getMemId());

				int num = service.add(vo);

		
		
		return "redirect:list";
	}
	
	//게시글 삭제 기능
	//링크된 글에서 게시글 번호를 가져와서 삭제 실행(별도의 추가코드없이 파라미터 입력 가능)
	@RequestMapping("/{postNo}/delete")
	String delete(@PathVariable int postNo) {
		service.delete(postNo);
		return "index";
	}
	
	//게시글 수정 기능
	@GetMapping("/{postNo}/update")
	String update(@PathVariable int postNo, Model model) {
		
		Post vo = service.postData(postNo);
		
		model.addAttribute("postData",vo);
		return path + "update";
	}
	//게시글 수정 기능
	@PostMapping("/{postNo}/update")
	String update(@PathVariable int postNo, Post post) {
		post.setPostNo(postNo);
		
		service.update(post);
		
	
		return "redirect:../list";
	}
	
	
	//좋아요기능
	
	@ResponseBody
	@PostMapping("/like")
	String like(@RequestBody Post post) {
		System.out.println(post.toString());
		
		int ch= service.like_check(post);
		int poNo = post.getPostNo();
		
		if (ch==0) 
			service.like_add(post);
			
		else
			service.like_delete(post);
		
		int like = service.checkLike(poNo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		JSONObject obj = new JSONObject();

		System.out.println(like);
		obj.put("likeCh", ch);
		obj.put("like", like);

		return obj.toJSONString();
	}
	
	///////검색


	@PostMapping("/newList")
	String newList(Post id, Model model) {
		
		System.out.println(id.toString()+"++++++++++++++++++++++");
		
		List<Post> list = service.newList(id);
		model.addAttribute("newList", list);
		return path + "newList";
	}
}
