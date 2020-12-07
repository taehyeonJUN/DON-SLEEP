package kr.ac.kopo.sns.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.sns.model.Member;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		Member info = (Member) session.getAttribute("user");
		
		if("ADMIN".equals(info.getMemAuthor()) || "USER".equals(info.getMemAuthor())) {
			
			System.out.println("권한은:"+info.getMemAuthor());
			return true;
		}else {
			response.sendRedirect("..");
			System.out.println("admin도 user도 아님");
			return false;
		}
		
	}
	
}

