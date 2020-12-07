package hi.pizza.world.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController{
	@Resource(name = "studentService")
	private StudentService studentService;

	@RequestMapping(value ="/student/list.do" )

	public String list(Map modeMap){
		List<StudentVo> list = studentService.selectStudentList();
		modeMap.put("StudentList", list);
		return "student/StudentList";
	}

	@RequestMapping(value = "/student/add.do", method = RequestMethod.GET )

	protected String addform() {
		return "student/StudentAddForm";
	}

	@RequestMapping(value = "/student/add.do",method = RequestMethod.POST )
	public String add(StudentVo vo) {
		int num = studentService.insertStudent(vo);
		System.out.println(num + "명의 학생 추가");
		return "redirect:/student/list.do";
	}

	@RequestMapping(value = "/student/edit.do", method = RequestMethod.GET)
	public String editform(String stuNo,Map modelMap) {
		StudentVo vo = studentService.selectStudent(stuNo);

		modelMap.put("StuVo", vo);
		return "student/StudentEditForm";
	}

	@RequestMapping(value = "/student/edit.do", method = RequestMethod.POST)
	public String edit(StudentVo vo){
		int num = studentService.updateStudent(vo);
		System.out.println(num+"개의 레코드 변경");		 
		return "redirect:/student/list.do";
	}

	@RequestMapping("/student/del.do")
	public String del(String StuNo){
		int num = studentService.deleteStudent(StuNo);
		System.out.println(num+"명의 학생을 삭제");
		return "redirect:/student/list.do";
	}
}
