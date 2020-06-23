package dynamic_beat_01;

import java.awt.*;

import javax.swing.*;

public class DynamicBeat extends JFrame{
//JFrame-GUI기반 프로그램을 만들기 위한 기본적으로 상속 받는 클래스
	
	
	//더블버퍼링 - 버퍼에 이미지를 담아 매순간 로딩
	private Image screenImage;
	private Graphics screenGraphics;

	private Image bag; //이미지를 담을수있는 객체
	
	public DynamicBeat() {
		setTitle("DynamicBeat");//프로그램 이름
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//전체 게임창의 크기 설정
		setResizable(false);//게임창의 크기 변경 불가
		setLocationRelativeTo(null);//실행시 컴퓨터의 정중앙에 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창 종료시 게임프로그램 전체 종료
		setVisible(true);//만들어진 프로그램이 정상적으로 화면 송출되게 함. 기본값이 false임
		
		bag= new ImageIcon(Main.class.getResource("../dynamic_beat_02/images/bag.png")).getImage();
	}
	public void paint (Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//설정한 크기의 이미지를 만들어 변수에 넣어줌
		screenGraphics = screenImage.getGraphics(); //스크린 이미지를 통해 그래픽 객체를 얻어옴
		screenDraw(screenGraphics);//그래픽 객체로 그림을 그림
		g.drawImage(screenImage,  0, 0, null);//설정한 위치에 그림을 그림
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(bag,  0, 0, null);
		this.repaint();//반복되게 그림을 만들어주게 만드는 역할
	}
	

}
