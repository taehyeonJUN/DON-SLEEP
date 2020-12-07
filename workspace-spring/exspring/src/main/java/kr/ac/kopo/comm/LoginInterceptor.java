package kr.ac.kopo.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.member.MemberVo;


//public class LoginInterceptor implements HandlerInterceptor{
	public class LoginInterceptor extends HandlerInterceptorAdapter{
	//필터는 인터페이스!
	//필터 : 지정된 주소로 요청이 왔을떄, 서블릿의 실행 전과 후에 실행되는 객체
	//여러 서블릿에서 공통적으로 실행해야하는 전처리/후처리 작업 구현시 사용
	// - 등록 방법
	// (1) @WebFilter("요청주소")를 필터 클래스에 적용하여 등록
	// (2) web.xml 설정파일에 등록
	
	//핸들러 인터셉터 : 컨트롤러가 실행되기 전과 후에 실행되는 객체
	//필터는 스프링 (디스패쳐 서블릿) 실행 전과 후에 실행되는 객체이고, 핸들러 인터셉터는 스프링 (디스패쳐 서블릿) 실행 후에 스프링을 통해 실행된다
	//다수의 컨트롤러에서 공통적으로 수행해야하는 작업을 실행하기에 적합
	


	//컨트롤러 실행되기 전에 실행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	System.out.println("LoginInterceptor : preHandle");
	//로그인 검사 수행
			HttpSession session = request.getSession();
			MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");
			if(loginVo==null) { //로그인하지 않은 경우
				//로그인 화면으로 이동
				response.sendRedirect(request.getContextPath()+"/member/login.do");
				return false;
			}
		return true;//컨트롤러 실행
		//반환값을 사용하여 이후 실행될 인터셉터와 컨트롤러의 실행 여부를 결정
	}

	//컨트롤러 실행후, 화면 출력 전에(jsp 실행 전) 실행되는 메서드
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("LoginInterceptor : postHandle");
//		
//	}
//
//	//화면 출력까지 모두 끝난 후, 실행 되는 메서드
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		System.out.println("LoginInterceptor : afterCompletion");
//		
//	}

}

//1. 회원추가도 로그인 안하고 쓰게끔.
//2. 로그인 안 한 경우에는 로그인, 회원가입 메뉴만 나오게,
//3. 로그인 한 경우에는 회원관리, 게시판, 학생관리, 로그아웃 메뉴가 나오도록 menu변경
//4. 게시판 새 글을 쓸 경우 로그인 한 사람의 아이디가 자동으로 글 작성자로 저장