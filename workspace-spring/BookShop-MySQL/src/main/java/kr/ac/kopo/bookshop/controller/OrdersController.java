package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Orders;
import kr.ac.kopo.bookshop.service.OrdersService;
import kr.ac.kopo.bookshop.util.Pager;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	final String path = "orders/";

	@Autowired
	OrdersService service;
	
	@GetMapping("/{orderid}/view")
	String view(@PathVariable int orderid, Model model) {
		Orders item = service.item(orderid);
		
		model.addAttribute("item", item);
		
		return path + "view";
	}
	
	@GetMapping("/list")
	String list(Model model, Pager pager) {
		List<Orders> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Orders item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/{orderid}/update")
	String update(@PathVariable int orderid, Model model) {
		Orders item = service.item(orderid);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/{orderid}/update")
	String update(@PathVariable int orderid, Orders item) {
		item.setOrderid(orderid);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/{orderid}/delete")
	String delete(@PathVariable int orderid) {
		service.delete(orderid);
		
		return "redirect:../list";
	}
	
}
