package kr.ac.kopo.bbs0612;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.member.MemberVo;

@Controller
public class BbsController{
	 @Resource(name = "bbsService")
	   private BbsService bbsService;


 @RequestMapping(value ="/bbs/list.do", method = RequestMethod.GET)
public String list(Map modelMap) {
	List<BbsVo> list=bbsService.selectBbsList();
	
	modelMap.put("bbsList", list);
	return "Bbs0612/BbsList";
	
}

@RequestMapping(value = "/bbs/add.do", method = RequestMethod.GET)
public String addform()  {
	return "Bbs0612/BbsAddForm";
}

@RequestMapping(value = "/bbs/add.do", method = RequestMethod.POST)
public String add(BbsVo vo , HttpSession session)  {
	 // 로그인한 사용자의 아이디를 게시글 작성자로 강제 설정
	MemberVo loginVo=(MemberVo) session.getAttribute("loginUser");
	vo.setBbsWriter(loginVo.getMemId());
	
	int num =bbsService.insertBbs(vo);


	
	return "redirect:/bbs/list.do";
}

@RequestMapping(value = "/bbs/Edit.do", method = RequestMethod.GET)
public String editform(int bbsNo, Map modelMap)  { //원래 bbsNo를 받는 변수인 no이 있었는데 그것을 bbsNo로 통일시켜주면 된다.
	
	BbsVo vo = bbsService.selectBbs(bbsNo);
	modelMap.put("bbsVo", vo);
	return "Bbs0612/BbsEdit";
}

@RequestMapping(value = "/bbs/Edit.do", method = RequestMethod.POST)
public String edit(BbsVo vo){
	int num=bbsService.updateBbs(vo);
	return "redirect:/bbs/list.do";//해당 브라우저에게 보내는것.


}

@RequestMapping(value = "/bbs/Del.do")
public String del(int bbsNo){
    int num = bbsService.deleteBbs(bbsNo);
    return "redirect:/bbs/list.do";
 }

//바이너리파일을 응답으로 전송하고 싶은 경우,
//컨트롤러 메서드의 반환타입은 void로 설정하고,
//인자로 응답객체를 받아서 응답객체에 파일내용을 출력
@RequestMapping(value = "/bbs/down.do")
public void down(int attNo, HttpServletResponse resp){
    AttachVo vo = bbsService.selectAttach(attNo);
    
    File f = bbsService.getAttachFile(vo); //현재 첨부파일의 서버컴퓨터상의 저장한 정보
    
    //응답데이터의 내용이 바이너리파일임을 알려주기
    resp.setContentType("application/octet-stream");
    String fName = vo.getAttOrgName();
    try {//한글파일명이 깨지지 않도록,URL에 사용가능한 문자로 인코딩하고, "+"문자로 변환된 공백문자를 "%20"으로 변환(공백을 나타냄)
		fName=URLEncoder.encode(fName, "UTF-8").replaceAll("\\+", "%20");
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    resp.setHeader("Content-Disposition", "attachment; filename*=UTF-8''"+ fName);
    
    try {
		FileCopyUtils.copy(new FileInputStream(f),resp.getOutputStream());
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
    

  
 }















}
