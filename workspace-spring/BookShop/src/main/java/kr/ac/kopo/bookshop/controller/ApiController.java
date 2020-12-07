package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.model.Bookinfo;
import kr.ac.kopo.bookshop.model.Pager;
import kr.ac.kopo.bookshop.service.BookService;

//api를 제공하기위해선 @ResponseBody를 method마다 붙여야 하지만 아래 어노테이션으로 인해 안써도 됨
@RestController
@RequestMapping("/api")
public class ApiController {


	@Autowired
	BookService service;
	
//bookshop을 api로 활용하기 위한 컨트롤러
//	@GetMapping("")
//	@PostMapping
	@RequestMapping(value="" , method = {RequestMethod.GET, RequestMethod.POST})
	Bookinfo list(@RequestBody Pager pager){
		
		//@RequestBody 를쓰면 폼 태그에 쓰는 페이지값을 주소줄이 아닌 프로토콜 안에 있는 값을 반영
		//model  타입을 사용하지 않아 jsp로 전송하지 못함 > json사용으로 해결
		//			json : 자바스크립트에서 객체를 표현하는 방법 
		//			서버가 결과를 처리하고 http가 아닌 제이슨 형태로 전달
		
		//pom.xml에서 설정 >Jackson Databind 최신버전
		//List<Book>라는 자바 객체를 제이슨 형식으로 바꿔주는 라이브러리
		
//		클라이언트에서 서버로 서버에서 처리된 결과를 클라이언트로 보내줄때,
//		제이슨형식에서 자바객체로 자바객체에서 제이슨 형식 결과로 변환해 주는 게 잭슨의 역할
		
		//postman에서 api가 되는지 확인이 가능함.
		//브라우저에서는 테스트 불가
		//get메소드로 테스트 헤더에 컨텐트 타입 -어플리케이션 제이슨 입력 후
		//바디에서 제이슨 형식으로 페이지 번호 {page:3}입력 후 확인
		//제이슨 형태로 보여짐
		
		//이렇게 하는 이유는 전송되는 데이터의 양을 최소화하기 위해(모바일 사용자에게 부담이 감)
		
		Bookinfo info = new Bookinfo();
		
		info.setList(service.list(pager));
		info.setPager(pager);
		
		return info;
	}
	
	@DeleteMapping()
	void delete(@RequestBody Book item) {
		service.delete(item.getBookid());
	}
	
	//값이 완전히 바뀔때
	@PutMapping
	void add (@RequestBody Book item) {
		service.add(item);
	}
	//값이 부분만 바뀔떄
	@PatchMapping
	void update(@RequestBody Book item) {
		service.update(item);
	}
	
}
