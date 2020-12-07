package com.exam;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ma") //"ma"라는 이름으로 스프링에 등록 "" 이런식으로 등록을 해도 자동으로 이름 생성되어 등록됨
//이름을 생략하며느 클래스명의 첫글자만 소문자로 변경한 이름으로 등록
public class MyApp {
	//스프링에 등록된 객체를 이 속성에 주입(저장)하기 위해서는 
//	@Autowired
//	@Inject
//	@Resource 중 하나를 사용  //타입을 기준으로 1차, 타입이 같은게 있다면 이름을 기준으로 찾음
	@Resource //(name="msen") //스프링에 esen으로 등록된 객체를 이 변수에 주입
//	@Resource //naeme을 생략하면 변수이름으로 name사용
				//스프링에 등록된 객체들 중 이름이 일치하는 객체를 못 찾으면 타입이 일치하는 객체를 주입
	private MyService myService;
	
	
	public MyService getMyService() {
		return myService;
	}
	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	
	public void sayHello() {
		System.out.println(myService.getHelloMsg());
	}
	public void sayBye() {
		System.out.println(myService.getByeMsg());
	}
}
