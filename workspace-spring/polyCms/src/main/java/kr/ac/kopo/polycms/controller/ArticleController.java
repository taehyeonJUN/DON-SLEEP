package kr.ac.kopo.polycms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.polycms.Service.ArticleService;
import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.model.Pager;

@Controller
@RequestMapping("/board/article/{boardId}")
public class ArticleController {

	@Autowired  //@Resource, @Inject를 대신 사용할수도 있음
	ArticleService service;
	
	final String path = "article/";
	
	@GetMapping("/list")
	String list(@PathVariable int boardId, Model model, Pager pager) {
		List<Article> list = service.list(boardId,pager);
		
		model.addAttribute("list", list);
		return path+"list";
	}
	
	@RequestMapping("/{articleId}/view")
	String view(@PathVariable int boardId, @PathVariable int articleId, Model model) {
		Article item = service.item(boardId,articleId);
	
		model.addAttribute("item", item);
		
		
		return path + "view";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	String add(@PathVariable int boardId) {
		return path + "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	String add(@PathVariable int boardId, Article item) {
		item.setBoardId(boardId);
		
		service.add(item);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/{articleId}/update", method = RequestMethod.GET)
	String update(@PathVariable int boardId, @PathVariable int articleId, Model model) {
		Article item=service.item(boardId,articleId);
		
		return path+"update";
	}
	
	@RequestMapping(value = "/{articleId}/update", method = RequestMethod.POST)
	String update(@PathVariable int boardId, @PathVariable int articleId, Article item) {
		item.setBoardId(boardId);
		item.setArticleId(articleId);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@RequestMapping(value ="/{articleId}/delete")
	String delete(@PathVariable int boardId, @PathVariable int articleId) {
		
		
		service.delete(boardId,articleId);
		
		return "redirect:../list";
	}
	
	
	@RequestMapping("/dummy")
	String dummy(@PathVariable int boardId) {
		service.dummy(boardId);
		return "redirect:list";
	}
	
	
	
}
