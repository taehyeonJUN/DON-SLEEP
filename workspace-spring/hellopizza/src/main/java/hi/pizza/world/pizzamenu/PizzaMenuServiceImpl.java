package hi.pizza.world.pizzamenu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("pizzaMenuService")
public class PizzaMenuServiceImpl implements PizzaMenuService{

	
	@Resource(name ="pizzaMenuDao")
	private PizzaMenuDao pizzaMenuDao;
	
	
	
	@Override
	public List<PizzaMenuVo> seletList() {
		return pizzaMenuDao.seletList();
	}



	@Override
	public int insertMenu(PizzaMenuVo vo) {
		
		return pizzaMenuDao.insertMenu(vo);
	}

	@Override
	public int updateMenu(PizzaMenuVo vo) {
		
		return pizzaMenuDao.updateMenu(vo);
	}

	@Override
	public int deleteMenu(int meId) {
		
		return pizzaMenuDao.deleteMenu(meId);
	}

	@Override
	public List<PizzaMenuVo> selectSize() {
		return pizzaMenuDao.selectSize();
	}

	@Override
	public List<PizzaMenuVo> selectTopping() {
		return pizzaMenuDao.selectTopping();
	}

	@Override
	public List<PizzaMenuVo> selectSide() {
		return pizzaMenuDao.selectSide();
	}

}
