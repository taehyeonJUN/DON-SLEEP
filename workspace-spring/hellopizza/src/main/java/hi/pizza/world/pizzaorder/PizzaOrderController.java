package hi.pizza.world.pizzaorder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hi.pizza.world.member.MemberVo;
import hi.pizza.world.pizzamenu.PizzaMenuVo;

@Controller("/order/list.do")
public class PizzaOrderController {

	@Resource(name ="pizzaOrderService")
	private PizzaOrderService pizzaOrderService;
	
	
//	최종 주문 확인
	@RequestMapping(value = "/order/od.do")
	public String selectOrder(Map modelMap, HttpSession session,PizzaOrderVo vo) {
//		주문번호 조회해서 삽입
		MemberVo loginVo=(MemberVo)session.getAttribute("loginUser");
		vo.setOrUser(loginVo.getMemId());
		String user = vo.getOrUser();
		List<PizzaOrderVo> selectOrder = pizzaOrderService.selIdOr(user);
		
		modelMap.put("selectOrder", selectOrder);
		
//		List<PizzaOrderVo> selectLi = pizzaOrderService.selectLiEdit(liOrNum);
//		modelMap.put("selectLi", selectLi);
		
		return "pizzaMenu/PizzaAnd";
	}
	
	//안돼면 포스트방식
//	@RequestMapping(value = "/order/add.do")
//	public String add(PizzaOrderVo vo) {
//		
//		 // 로그인한 사용자의 아이디를 게시글 작성자로 강제 설정
////		MemberVo loginVo=(MemberVo) session.getAttribute("loginUser");
////		vo.setBbsWriter(loginVo.getMemId());
//		
//		int num =pizzaOrderService.insertOrder(vo);
//		return "redirect:/order/list.do";
//	}
//	
	
	//주문번호로 주문 조회
	@RequestMapping(value = "/order/list.do",method = RequestMethod.GET)
	public String editForm(PizzaOrderVo vo, Map modelMap, HttpServletRequest request ) {
//		주문번호 조회해서 삽입
		int idvo = pizzaOrderService.selNull();
		vo.setLiOrNum(idvo);
		int id = vo.getLiOrNum();
		
		System.out.println("*******"+idvo+"*******"+vo.getLiOrNum());
		

		PizzaOrderVo selectOrList = pizzaOrderService.selectOrList(id);
		modelMap.put("selectOrList", selectOrList);
		
		
		List<PizzaOrderVo> selectLiEdit=pizzaOrderService.selectLiEdit(id);
		modelMap.put("selectLiEdit", selectLiEdit);
		
		int price = pizzaOrderService.sumPrice(id);
		modelMap.put("price", price);
		
		return "pizzaMenu/PizzaOrder";
	}
//	
	@RequestMapping(value = "/order/list.do",method = RequestMethod.POST)
	public String edit(PizzaOrderVo vo) {
		int num = pizzaOrderService.updateOrder(vo); 
		
		return "redirect:/order/od.do";
	}
//	
	
	
	
///////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////
	//주문목록
	
//	@RequestMapping(value = "/order/list.do",method = RequestMethod.GET)
//	public String selectLi(Map modelMap) {
//		List<PizzaOrderVo> selectLi = pizzaOrderService.selectLi();
//		modelMap.put("selectLi", selectLi);
//		
//		return "pizzaMenu/PizzaOrder";
//	}
//	
	//안돼면 포스트방식
	//주문생성
	@RequestMapping(value = "/order/add.do",method = RequestMethod.GET)
	public String addform(PizzaOrderVo vo, HttpSession session, Map modelMap) {
//		안의 값이 비어있는 주문 삭제
		pizzaOrderService.delNull();
		MemberVo loginVo=(MemberVo)session.getAttribute("loginUser");
		vo.setOrUser(loginVo.getMemId());
		int num =pizzaOrderService.insertOrder(vo);
//주문생성할떄 0값이 들어가므로 이걸 기준으로 주문번호 검색 + 주문 안할시 자동 삭제가 필요함
		
		
		return "redirect:/pizzaMenu/list.do";
		
	}
	
	@RequestMapping(value = "/order/add.do", method = RequestMethod.POST)
	public String insertLi(PizzaOrderVo  vo, HttpSession session, HttpServletRequest request,Map moMap ) {
		MemberVo loginVo=(MemberVo)session.getAttribute("loginUser");
		int idvo = pizzaOrderService.selNull();
		for (PizzaOrderVo povo : vo.getInsLi()) {
			povo.setLiUser(loginVo.getMemId());
			povo.setLiOrNum(idvo);
			System.out.println(povo.getLiMeid()+","+povo.getLiEa()+","+povo.getLiMeprice()+","+povo.getLiMename()+","+povo.getLiUser()+","+povo.getLiOrNum());
			if(povo.getLiEa()!=0) {				
			int num =pizzaOrderService.insertLi(povo);
			}else {
//				continue;
			}
		}//가격, 이름 , 주문번호  삽입필요

		// 로그인한 사용자의 아이디를 게시글 작성자로 강제 설정
		
//		주문번호 조회해서 삽입
		
		
		System.out.println("*******"+idvo+"*******"+vo.getLiOrNum());
		
		//메뉴아이디를 리스트의 메뉴아이디로 넣기
//		int cnt =Integer.parseInt(request.getParameter("meId"));
//		vo.setLiMeid(cnt);
		
//		int pri = pizzaOrderService.selectPrice(cnt);
//		String mname= pizzaOrderService.selectMeName(cnt);
//		vo.setLiMeprice(pri);
//		vo.setLiMename(mname);


		
		return "redirect:/order/list.do";
	}
//	
	@RequestMapping(value ="/List/list.do",method = RequestMethod.GET)
	public String editListForm(int orId, Map modelMap) {
//		여기서 주문번호 조회해서 저장?
		List<PizzaOrderVo> selectLiEdit=pizzaOrderService.selectLiEdit(orId);
		modelMap.put("selectLiEdit", selectLiEdit);
		
		int price = pizzaOrderService.sumPrice(orId);
		modelMap.put("price", price);
		return "pizzaMenu/PizzaList";
	}
//	
//	@RequestMapping(value = "/order/edit.do",method = RequestMethod.POST)
//	public String editList(PizzaOrderVo vo) {
//		int num = pizzaOrderService.updateLi(vo);
//		return "redirect:/order/list.do";
//	}
	
	
	@RequestMapping(value = "/order/Del.do")
	public String del(int orId){
	    int num = pizzaOrderService.deleteOrder(orId);
	    return "redirect:/order/od.do";
	 }
	
//	@RequestMapping(value = "/list/Del.do")
//	public String delLi(int liOrNum){
//	    int num = pizzaOrderService.deleteLi(liOrNum);
//	    return "redirect:/List/list.do";
//	 }

}
