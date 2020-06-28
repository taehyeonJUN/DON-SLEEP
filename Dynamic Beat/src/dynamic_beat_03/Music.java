package dynamic_beat_03;

import java.io.*;

import javazoom.jl.player.*;

public class Music  extends Thread{ //������� �ϳ��� ���� ���α׷��� �����Ѵ� ����

	private Player player; //�ڹ� �� ���̺귯���� Ŭ����
	private boolean isLoop; //�ݺ�����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis; //�ݺ�����
	
	public Music(String name, boolean isLoop) { //�� ���� ���ѹݺ�����
		try {
			this.isLoop=isLoop;
			file = new File(Main.class.getResource("../dynamic_beat_03/Music/"+name).toURI()); //�����ּ� ������
			fis = new FileInputStream(file);//���ϰ�����
			bis = new BufferedInputStream(fis);//���ۿ� ��� �о��
			player = new Player(bis); //�о�� ���� ����
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public int getTime() { //����Ǵ� ������ ��ġ�� �˷���(��� ����?)
		if(player == null) 
			return 0;
		return player.getPosition();
	}
	public void close() { //������ �� ����
		isLoop=false;
		player.close();
		this.interrupt(); // �ش� ������ ��������
	}
@Override
	public void run() { //������ ��ӽ� ������ ����ϴ� �Լ�	
		try {
			do {
				player.play();
				fis = new FileInputStream(file);//���ϰ�����
				bis = new BufferedInputStream(fis);//���ۿ� ��� �о��
				player = new Player(bis); //�о�� ���� ����
			} while (isLoop);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

}
	
}
