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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
      
      int check = service.add(rp);
      int ch = poservice.RpAmount(rp.getRpPostNo());
      JSONObject obj = new JSONObject();
      obj.put("ch", ch);
      
      return obj.toJSONString();
   }
   
   // 선택한 게시글만 조회 url명 혿동주의
   @ResponseBody
   @PostMapping("/rpList")
   RpInfo rpList(@RequestBody Rp rpPostNo) {
      JSONObject obj = new JSONObject();
      RpInfo info = new RpInfo();
      info.setList(service.selectList(rpPostNo));
      
      return info;
   }
   
   @RequestMapping("/delete")
   @ResponseBody
   HashMap<String, Object> delete(int rpNo) {
      
      int check = service.delete(rpNo);

      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("result", check);
      
      return map;
      
      }
   
   @RequestMapping("/update")
   @ResponseBody
   String update(int rpNo, Model model){
      service.read(rpNo);
//      upcheck 에 변수에 getrpNo담기
      if(1>0) 
         return "TRUE";
      else 
         return "FALSE";
   }
   


   
   
}