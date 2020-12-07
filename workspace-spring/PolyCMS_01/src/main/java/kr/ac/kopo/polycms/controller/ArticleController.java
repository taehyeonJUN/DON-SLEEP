package kr.ac.kopo.polycms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.model.Reply;
import kr.ac.kopo.polycms.service.ArticleService;
import kr.ac.kopo.polycms.service.ReplyService;
import kr.ac.kopo.polycms.utill.Pager;

@Controller
@RequestMapping("/board/article/{boardId}")
public class ArticleController {
	final String path = "article/";
	
	@Autowired //@Resource, @Inject
	ArticleService service;
	
	@Autowired
	ReplyService serviceReply;
	
	@RequestMapping("/dummy")
	String dummy(@PathVariable int boardId) {
		service.dummy(boardId);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/{articleId}/view", method = RequestMethod.GET)
	String view(@PathVariable int boardId, @PathVariable int articleId, Model model) {
		Article item = service.item(boardId, articleId);
		
		model.addAttribute("item", item);
		
		List<Reply> reply = serviceReply.list(boardId,articleId);
		model.addAttribute("reply", reply);
		
		return path + "view";	
	}
	
	@RequestMapping(value = "/{articleId}/view", method = RequestMethod.POST)
	String view(@PathVariable int boardId, @PathVariable int articleId, Reply item) {
		serviceReply.add(boardId,articleId,item);
		
		return "redirect:view";
	}
	
	
	
	@RequestMapping("/list")
	String list(@PathVariable int boardId, Model model, Pager pager) {
		List<Article> list = service.list(boardId, pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	String add(@PathVariable int boardId) {
		return path + "add";
	}
	
	@RequestMapping(value = "/add", method =RequestMethod.POST)
	String add(@PathVariable int boardId, Article item) {
		item.setBoardId(boardId);
		
		service.add(item);
		
		return "refirect:list";
	}
	
	@RequestMapping(value = "/{articleId}/update", method = RequestMethod.GET)
	String update(@PathVariable int boardId, @PathVariable int articleId, Model model) {
		Article item = service.item(boardId,articleId);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@RequestMapping(value = "/{articleId}/update", method = RequestMethod.POST)
	String update(@PathVariable int boardId, @PathVariable int articleId, Article item) {
		item.setBoardId(boardId);
		item.setArticleId(articleId);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@RequestMapping("/{articleId}/delete")
	String delete(@PathVariable int boardId, @PathVariable int articleId) {
		service.delete(boardId, articleId);
		
		return "redirect:../list";
	}

}
