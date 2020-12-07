package com.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//자바로 하는 설정파일 // 안써서 주석처리
//@Configuration //스프링 설정파일 역할을 하는 클래스임을 표시
public class MyConfig {

	@Bean(name = "ma") //스프링에 등록하는 어노테이션, 이 메소드에서 반환하는 객체를 스프링에 등록
	public MyApp ma() {
		MyApp myApp =new MyApp();
		myApp.setMyService(msen());
		
		return myApp;
	}
	
	@Bean //이름을 생략하면 메소드 이름으로 등록
	public MyService msen() {
		return new MyServiceEn();
		
	}
	
	@Bean
	public MyService msko() {
		return new MyServiceKo();
	}
	
}
