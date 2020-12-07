package hi.pizza.world.pizzamenu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PizzaMenuDao {
	
	
	//메뉴 관련
	
	List<PizzaMenuVo> seletList();
	

	List<PizzaMenuVo> selectSize();
	List<PizzaMenuVo> selectTopping();
	List<PizzaMenuVo> selectSide();
	
	int insertMenu(PizzaMenuVo vo);
	int updateMenu(PizzaMenuVo vo);
	int deleteMenu(int meId);

	

}
