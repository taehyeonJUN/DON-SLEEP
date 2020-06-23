package dynamic_beat_02;

import javax.swing.*;

public class DynamicBeat extends JFrame{
//JFrame-GUI기반 프로그램을 만들기 위한 기본적으로 상속 받는 클래스
	
	public DynamicBeat() {
		setTitle("DynamicBeat");//프로그램 이름
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//전체 게임창의 크기 설정
		setResizable(false);//게임창의 크기 변경 불가
		setLocationRelativeTo(null);//실행시 컴퓨터의 정중앙에 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창 종료시 게임프로그램 전체 종료
		setVisible(true);//만들어진 프로그램이 정상적으로 화면 송출되게 함. 기본값이 false임
	}
	

}
