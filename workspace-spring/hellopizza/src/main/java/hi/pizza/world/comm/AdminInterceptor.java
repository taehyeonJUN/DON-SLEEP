package hi.pizza.world.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import hi.pizza.world.member.MemberVo;

public class AdminInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		System.out.println("관리자인터셉터 프리핸들");
		// 관리자 권한 검사 수행
		
		HttpSession session =request.getSession(); //HttpSession는 java에 이미 저장되어있음
		MemberVo x = (MemberVo)session.getAttribute("loginUser"); //세션에서 loginUser이름으로 저장된 값을 가져와라. loginUser에는loginVo값을 담고있음
		//if(!(x.getROL().equals("admin"))) { // 로그인한 유저의 rol 값이 admin이 아닌 경우
		if(!("ADMIN".equals(x.getROL()))) { // 로그인한 유저의 rol 값이 admin이 아닌 경우
			//memlist에 접근 불가능하게 하고싶음
			response.sendRedirect(request.getContextPath()+"/home.do"); // 또는 관리자만 사용가능하다 알리는 에러페이지로 보낼 수도 있음 
			return false; //Controller 실행 X
		}
		
		
		return true;
	}
}
