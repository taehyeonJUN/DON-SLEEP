package kr.ac.kopo.polycms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.polycms.model.BoardMaster;
import kr.ac.kopo.polycms.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/list")
	String list(Model model) {
		List<BoardMaster> list = service.list();
		
		model.addAttribute("list", list);
		
		return"list";
	}

	@RequestMapping(value ="/add", method =RequestMethod.GET )
	String add() {
		
		return "add";
	}
	@RequestMapping(value ="/add", method =RequestMethod.POST)
	String add(BoardMaster item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@RequestMapping(value ="/update/{board_id}", method = RequestMethod.GET)
	String update(@PathVariable int board_id, Model model) {
		BoardMaster item = service.item(board_id);
		
		model.addAttribute("item", item);
		return "update";
	}
	
	@RequestMapping(value ="/update/{board_id}", method = RequestMethod.POST)
	String update(@PathVariable  int board_id, BoardMaster item) {
		service.update(item);
		
		return "redirect:../list";
	}
	
	@RequestMapping("/delete/{board_id}")
	String delete(@PathVariable int board_id) {
		service.delete(board_id);
		
		return "redirect:../list";
	}
}
