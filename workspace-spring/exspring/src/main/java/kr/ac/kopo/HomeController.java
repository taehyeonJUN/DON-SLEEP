package kr.ac.kopo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */

//@Controller의 @RequestMapping 메서드는 실행 결과로서 모델과 뷰 정보를 알려줘야한다.
//모델 : 응답에 포함되어야 하는 데이터 (jsp에서 꺼내어 사용할 데이터)
//뷰 : 응답 화면 출력을 담당하는 객체(어떤 jsp에서 꺼내어 사용할 데이터)
//컨트롤러 : 
@Controller // 웹요청을 받아서 실행되는 클래스임을 표시(서블릿과 유사한 역할)
public class HomeController {
	//로그 출력을 위한 로거 객체 가져오기
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
//	@RequestMapping으로 어떤 주소와 요청방식으로 요청이 왔을때 실행될 메서드인지를 설정
	@RequestMapping(value = "/home.do", method = RequestMethod.GET) ///home.do주소로 get방식 요청이오면 이 메서드를 실행
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date(); //현재 시간을 담은 객체 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date); //날짜,시간을 현재 로케일에 맞는 형태의 문자열로 변환 
		
		//모델에 "serverTime"라는 이름으로 formattedDate변수값을 저장
		// jsp에서는 ${serverTime} 라는 표현으로 formattedDate변수 값을 사용 가
		model.addAttribute("serverTime", formattedDate );
		
		//화면 출력을 위해 이동해야할 뷰(JSP)의 이름을 반환
		return "home"; ///exspring/src/main/webapp/WEB-INF/views/home.jsp
	}
	
	
	//@RequestMapping(value ="/test.do",method = RequestMethod.GET) //get방식 요청시
	//@RequestMapping(value ="/test.do") //요청방식에 상관없이 실행
	@RequestMapping("/test.do") //요청방식에 상관없이 실행
	public String test(
			@RequestParam("myNo") String no, // "myNo"라는 이름의 파라미터 값을 이 변수에 저장
			
			int myNo, // 변수 명이 파라미터명과 같은 경우 에는 @RequestParam생략 가능(자동 형변환 가능)
			
			//@ModelAttribute("mvo") 
			MyVo mv, //사용자가 정의한 객체의 변수에는 동일한 이름의 파라미터 값이 자동 저장  
			//**변수명 mv로 변경**  
			//**@ModelAttribute에 ("mvo")라는 이름으로 추가 map.put("mvo", mv);와 같은 효과
			//**파라미터를 받기 위한 객체는 자동으로 모델에 추가.
			//**모델에 저장되는 이름은 타입(클래스)의 첫글자만 소문자로 바꾼 이름을 사용
			
			
			Model model, ModelMap modelmap, Map map) {  
	// http://localhost:7999/kopo/test.do 로 요청을 보내면 test.jsp화면이 나오도록 구현
		System.out.println("myNo :" + no);
		System.out.println("myNo :" + myNo);
		System.out.println("mv의 myNo :" + mv.getMyNo()); //**이 값을 jsp로 출력 
		System.out.println("mv의 myId :" + mv.getMyId());
		
		String s = "Hello,Spring";
		//모델에 데이터를 추가하는 방법 
		//인자로 받은 Model, ModelMap, Map 객체에 데이터를 저장
		model.addAttribute("modelVal", s); //s를 "modelVal"이라는 이름으로 저장
		modelmap.addAttribute("modelmapVal", s); //셋중 하나만 쓰면 됨. 모델은 자바 자체 나머지는 스프링에 속함
		map.put("mapVal", s);
		map.put("mapVal", mv);
		
		
		
		// **
		
//		String x = "mv의 myNo :" + mv.getMyNo();
//		String y = "mv의 myId :" + mv.getMyId();
	
//		map.put("myNoMap",x);
//		map.put("myIdMap",y);
		
		map.put("mvo", mv);
		//**
		
		return "test"; // WEB-INF/views/test.jsp //뷰 정보를 반환
	}
	
	@RequestMapping("/clock.do")
	public String clock() {
		return "clock";
	}
	
//JSON형식 : 자바스크립트 객체표현과 동일하고, 2가지 다른점 존재
//(1) 속성 이름을 문자열로 표현 (2)문자열은 ""만 사용
//	var obj = {now : '2020-07-22 11:42:22',num : 7'};//자바스크립트 객체
//	{"now" : "2020-07-22 11:42:22","num":7} //json문자열
	
	
	@RequestMapping("/data.do")
	@ResponseBody //메서드의 반환값 자체가 응답 데이터로 전송되어야 함을 표시 
	public Map<String,Object> data() {
		Date d = new Date();
		String ds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
		int n =(int)(Math.random()*10);
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("now", ds);
		map.put("num", n);
//		return "{\"now\" : \""+ds+"\", \"num\" : "+n+"}" ;
		
		return map;
	}
	
	
	
	
	
	
	
	
	
	
}
