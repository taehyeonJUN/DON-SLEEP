package hi.pizza.world.pizzaorder;

import java.util.List;


public interface PizzaOrderService {
	//주문관련
	List<PizzaOrderVo> selectOrder(); //주문출력
	PizzaOrderVo selectOrList(int orId);
	int insertOrder(PizzaOrderVo vo); //주문생성
	int updateOrder(PizzaOrderVo vo); // 주문수정
	int deleteOrder(int orId); //주문삭제
	
	//목록관련
	List<PizzaOrderVo> selectLi(); //목록
	List<PizzaOrderVo> selectLiEdit(int liOrNum);
	int insertLi(PizzaOrderVo vo); //목록생성
	int updateLi(PizzaOrderVo vo); // 목록수정
	int deleteLi(int liOrNum); //목록삭제
	
	int selNull(); //빈 주문 확인

	int delNull(); //빈 주문값 삭제
	
	int selectPrice(int liMeid);
	String selectMeName(int liMeid);
	
	List<PizzaOrderVo> selIdOr(String orUser);//회원아이디로 주문 조회
	
	int sumPrice(int liOrNum);//금액 합계
}
