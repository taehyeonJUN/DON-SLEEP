package com.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//스프링 = IOC/DI와 AOP기능을 지원하는  객체(Bean)를 담고있는 컨테이너 =  ApplicationContext
//AOP : 코드를 원하는곳에 자동 삽입,삭제


public class AppMain {

	public static void main(String[] args) {
	
		
//		MyApp myApp = new MyApp();
		//클래스 패스에서 "com/exam/context.xml" 설정파일에 적혀있는대로
		//객체들을 생성하여 담고 있는 ApplicationContext를 생성
		// ApplicationContext==스프링 본체 == 객체를 담고 있는 컨테이너
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/exam/context.xml");
		
		//MyConfig에 클래스에 자바로 작성한 설정내용대로 스프링 객체 컨테이너 생성
	//	ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		MyApp myApp=(MyApp) context.getBean("ma"); //스프링에 "ma"라는 이름으로 등록된 객체 가져오기
//		MyApp myApp=context.getBean(MyApp.class); // 스프링에 등록되어있는 객체중 MyApp타입의 객체 가져오기
		
		MyApp myApp2=(MyApp) context.getBean("ma");
		System.out.println(myApp==myApp2); //객페는 한번만 등록되어 사용 (싱글톤)
		
		myApp.sayHello();
		myApp.sayBye();
		
		String[] names = context.getBeanDefinitionNames();
		for (String n : names) {
			System.out.println(n);
		}
	}

}
