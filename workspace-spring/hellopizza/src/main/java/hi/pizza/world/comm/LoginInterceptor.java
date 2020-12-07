package hi.pizza.world.comm;

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

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import hi.pizza.world.member.MemberVo;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor : preHandle!");
		HttpSession session =request.getSession(); //HttpSession는 java에 이미 저장되어있음
		MemberVo x = (MemberVo)session.getAttribute("loginUser"); //세션에서 loginUser이름으로 저장된 값을 가져와라. loginUser에는loginVo값을 담고있음
		if(x == null) 
		{ // 로그인하지 않은 경우
			//로그인 화면으로 이동 
			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false; //Controller 실행 X
		}
		return true;
	
		
			 
			
		
	}
	
}
