package hi.pizza.world.pizzaorder;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("pizzaOrderService")
public class PizzaOrderServiceImpl implements PizzaOrderService{
	
	@Resource(name ="pizzaOrderDao")
	private PizzaOrderDao pizzaOrderDao;

	@Override
	public List<PizzaOrderVo> selectOrder() {
		return pizzaOrderDao.selectOrder();
	}

	@Override
	public int insertOrder(PizzaOrderVo vo) {
		
		return pizzaOrderDao.insertOrder(vo);
	}

	@Override
	public int updateOrder(PizzaOrderVo vo) {
		
		return pizzaOrderDao.updateOrder(vo);
	}

	@Override
	public int deleteOrder(int orUser) {
	
		return pizzaOrderDao.deleteOrder(orUser);
	}

	@Override
	public PizzaOrderVo selectOrList(int orId) {
		return pizzaOrderDao.selectOrList(orId);
	}

	
	
	
	//////////////////////////////////
	//목록관련
	@Override
	public List<PizzaOrderVo> selectLi() {
		// TODO Auto-generated method stub
		return pizzaOrderDao.selectLi();
	}

	@Override
	public List<PizzaOrderVo> selectLiEdit(int liOrNum ) {
		return pizzaOrderDao.selectLiEdit(liOrNum);
	}

	@Override
	public int insertLi(PizzaOrderVo vo) {
//		인서트 메소드를 인트로 바꾸로 매개는 리스트로 유지?
//		여기서 for문 사용하여 인서트 여러번 실행
//		for (int i = 0; i < insLi.size(); i++) {
//		
//			
//		}
//		for (PizzaOrderVo pizzaOrderVo : insLi) {
//			
//		}
		return pizzaOrderDao.insertLi(vo);
	}

	@Override
	public int updateLi(PizzaOrderVo vo) {
		return pizzaOrderDao.updateLi(vo);
	}

	@Override
	public int deleteLi(int liOrNum) {
		return pizzaOrderDao.deleteLi(liOrNum);
	}

	@Override
	public int selectPrice(int liMeid) {
		
		return pizzaOrderDao.selectPrice(liMeid);
	}

	@Override
	public String selectMeName(int liMeid) {
		
		return pizzaOrderDao.selectMeName(liMeid);
	}

	@Override
	public int selNull() {
		
		return pizzaOrderDao.selNull();
	}

	@Override
	public int delNull() {
		
		return pizzaOrderDao.delNull();
	}

	@Override
	public List<PizzaOrderVo> selIdOr(String orUser) {
		
		return pizzaOrderDao.selIdOr(orUser);
	}

	@Override
	public int sumPrice(int liOrNum) {
		
		return pizzaOrderDao.sumPrice(liOrNum);
	}
	
	
	
	
	

}
