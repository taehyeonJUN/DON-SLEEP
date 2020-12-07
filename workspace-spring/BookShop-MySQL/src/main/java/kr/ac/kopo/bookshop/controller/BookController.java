package kr.ac.kopo.bookshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.service.BookService;
import kr.ac.kopo.bookshop.service.OrdersService;
import kr.ac.kopo.bookshop.util.Pager;

@Controller
@RequestMapping("/book")
public class BookController {
	final String path = "book/";

	@Autowired
	BookService service;
	
	@Autowired
	OrdersService serviceOrders;

	private String uploadPath= "d://upload/";
	
	
	@GetMapping("/{bookid}/view")
	String view(@PathVariable int bookid, Model model) {
		Book item = service.item(bookid);
		model.addAttribute("item", item);
		
		return path+"view";
	}
	
	@GetMapping("/order")
	String order(HttpSession session) {
		@SuppressWarnings("unchecked")
		Map<Integer, Book> cart = (Map<Integer, Book>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Integer, Book>();
			
			session.setAttribute("cart", cart);
		}
		
		Customer customer = (Customer) session.getAttribute("user");		
		
		serviceOrders.order(customer, cart);
		
		return "redirect:list";
	}
	
	@GetMapping("/cart")
	String cart(Integer bookid, HttpSession session) {
		@SuppressWarnings("unchecked")
		Map<Integer, Book> cart = (Map<Integer, Book>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Integer, Book>();
			
			session.setAttribute("cart", cart);
		}
		
		if(bookid != null) {
			Book item = service.item(bookid);
			
			Book book = cart.get(bookid);
			if(book == null)			
				cart.put(bookid, item);
			else
				book.setAmount( book.getAmount() + 1 );
		}
		
		return path + "cart";
	}
	
	@GetMapping("/dummy")
	String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	@GetMapping("/init")
	String init() {
		service.init();
		
		return "redirect:list";
	}
	
	@GetMapping({"", "/list"})
	String list(Model model, Pager pager) {
		List<Book> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Book item) {
		MultipartFile upload = item.getUploadFile();
		if (upload != null && upload.getSize() > 1) {
			//getSize는 파일 용량을 말하며 0바이트짜리를 제외하기 위해 조건을 검
			try {
				String fileName = upload.getOriginalFilename();
				item.setCover(fileName);
				upload.transferTo(new File(uploadPath + fileName));
				
				service.add(item);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return "redirect:list";
	}
	
	@GetMapping("/{bookid}/update")
	String update(@PathVariable int bookid, Model model) {
		Book item = service.item(bookid);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/{bookid}/update")
	String update(@PathVariable int bookid, Book item) {
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/{bookid}/delete")
	String delete(@PathVariable int bookid) {
		service.delete(bookid);
		
		return "redirect:../list";
	}
	
}
