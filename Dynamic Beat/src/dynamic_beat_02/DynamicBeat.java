package dynamic_beat_02;

import javax.swing.*;

public class DynamicBeat extends JFrame{
//JFrame-GUI��� ���α׷��� ����� ���� �⺻������ ��� �޴� Ŭ����
	
	public DynamicBeat() {
		setTitle("DynamicBeat");//���α׷� �̸�
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//��ü ����â�� ũ�� ����
		setResizable(false);//����â�� ũ�� ���� �Ұ�
		setLocationRelativeTo(null);//����� ��ǻ���� ���߾ӿ� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����â ����� �������α׷� ��ü ����
		setVisible(true);//������� ���α׷��� ���������� ȭ�� ����ǰ� ��. �⺻���� false��
	}
	

}
