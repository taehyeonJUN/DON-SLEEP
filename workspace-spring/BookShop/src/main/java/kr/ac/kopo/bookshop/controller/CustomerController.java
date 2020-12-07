package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.model.Pager;
import kr.ac.kopo.bookshop.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	final String path = "customer/";

	@Autowired
	CustomerService service;
	
	@GetMapping("/list")
	String list(Model model, Pager pager) {
		List<Customer> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path+"list";
		
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Customer item) {
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("{custid}/update")
	String update(@PathVariable int custid,Model model) {
		Customer item = service.item(custid);
		model.addAttribute("item", item);
		return path + "update";
	}
	
	@PostMapping("{custid}/update")
	String update(@PathVariable int custid, Customer item) {
		item.setCustid(custid);
		service.update(item);
		
		return "redirect:../list";

	}
	//@PathVariable이 붙으면 주소처리가 이어서 되므로 ..으로 앞으로 이동
	
	@RequestMapping("{custid}/delete")
	String delete(@PathVariable int custid) {
		service.delete(custid);
		return "redirect:../list";
 
	}
	
}
