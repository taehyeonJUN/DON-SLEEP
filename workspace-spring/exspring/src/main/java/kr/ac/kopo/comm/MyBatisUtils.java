package kr.ac.kopo.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	private static SqlSessionFactory sqlSessionFactory; 
	
	
	static{
		try {
			//지정한 위치의 마이바티스 설정파일을 읽어서 SqlSessionFactory를 생성
			String resource = "batis/mybatis-config.xml"; //마이배티스 설정파일 경로
			InputStream inputStream = Resources.getResourceAsStream(resource); //경로해석해서 값을 받아오고(파이프)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//설정파일을 만들어 세션팩토리(마이배티스의 본체역할) 생성
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
		
	}
	
}
