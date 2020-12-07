package kr.ac.kopo.polycms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.polycms.Service.ArticleService;
import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.model.Pager;

@Controller
public class RootController {
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/")
	String index(Model model) {
		
		Pager pager = new Pager();
		pager.setPerPage(5);
		
		List<Article> notice = articleService.list(7, pager);
		model.addAttribute("notice", notice);
		
		List<Article> feq = articleService.list(9, pager);
		model.addAttribute("feq", feq);
	
		return "index";
	}
}
