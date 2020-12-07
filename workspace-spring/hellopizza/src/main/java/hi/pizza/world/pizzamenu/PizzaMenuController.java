package hi.pizza.world.pizzamenu;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PizzaMenuController {

	@Resource(name ="pizzaMenuService")
	private PizzaMenuService pizzaMenuService;
	
	
	
	@RequestMapping(value ="/pizzaMenu/list.do")
	public String seletList(Map modelMap) {
		
		List<PizzaMenuVo> seletList = pizzaMenuService.seletList();
		modelMap.put("seletList", seletList);
		
		
		//토핑 출력
		List<PizzaMenuVo> selectTopping = pizzaMenuService.selectTopping();
		modelMap.put("selectTopping", selectTopping);
		//사이즈 출력
		List<PizzaMenuVo> selectSize = pizzaMenuService.selectSize();
		modelMap.put("selectSize", selectSize);
		//사이드 출력
		List<PizzaMenuVo> selectSide = pizzaMenuService.selectSide();
		modelMap.put("selectSide", selectSide);
		
		
		return "pizzaMenu/PizzaMenu";
	}
	

	
	

}
