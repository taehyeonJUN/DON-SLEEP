package kr.ac.kopo.student;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

@Resource(name="stuService")
protected StuService stuService;
	
	
	@RequestMapping(value ="/student/list.do")
	public String list(Map modelMap) {
		
		List<StuVo> list = stuService.seletStuList();
		modelMap.put("StuList", list);
		
		return "stu0603/StuList";
	}
	
	@RequestMapping(value ="/student/add.do",method = RequestMethod.GET )
	public String addform(){
		return "stu0603/StuAddForm";
	}
	
	@RequestMapping(value ="/student/add.do",method = RequestMethod.POST)
	public String add(StuVo vo) {
		int num = stuService.insertStu(vo);
		return "redirect:/student/list.do";
	}
	
	@RequestMapping(value ="/student/edit.do",method = RequestMethod.GET )
	public String editfrom(String stuNo, Map modelMap){

		StuVo vo = stuService.seletStu(stuNo);
		modelMap.put("stuVo", vo);
		return "stu0603/StuEditForm";
	}
	
	
	@RequestMapping(value ="/student/edit.do",method = RequestMethod.POST)
	public String edit(StuVo vo){

		int num = stuService.updateStu(vo);
		return "redirect:/student/list.do";
	}
	
	@RequestMapping(value = "/student/del.do")
	public String del(String stuNo){

		int num = stuService.delStu(stuNo);
		return "redirect:/student/list.do";
	}
	
	
	
	
}

	
