package dynamic_beat_01;

import java.awt.*;

import javax.swing.*;

public class DynamicBeat extends JFrame{
//JFrame-GUI��� ���α׷��� ����� ���� �⺻������ ��� �޴� Ŭ����
	
	
	//������۸� - ���ۿ� �̹����� ��� �ż��� �ε�
	private Image screenImage;
	private Graphics screenGraphics;

	private Image bag; //�̹����� �������ִ� ��ü
	
	public DynamicBeat() {
		setTitle("DynamicBeat");//���α׷� �̸�
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//��ü ����â�� ũ�� ����
		setResizable(false);//����â�� ũ�� ���� �Ұ�
		setLocationRelativeTo(null);//����� ��ǻ���� ���߾ӿ� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����â ����� �������α׷� ��ü ����
		setVisible(true);//������� ���α׷��� ���������� ȭ�� ����ǰ� ��. �⺻���� false��
		
		bag= new ImageIcon(Main.class.getResource("../dynamic_beat_02/images/bag.png")).getImage();
	}
	public void paint (Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//������ ũ���� �̹����� ����� ������ �־���
		screenGraphics = screenImage.getGraphics(); //��ũ�� �̹����� ���� �׷��� ��ü�� ����
		screenDraw(screenGraphics);//�׷��� ��ü�� �׸��� �׸�
		g.drawImage(screenImage,  0, 0, null);//������ ��ġ�� �׸��� �׸�
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(bag,  0, 0, null);
		this.repaint();//�ݺ��ǰ� �׸��� ������ְ� ����� ����
	}
	

}
