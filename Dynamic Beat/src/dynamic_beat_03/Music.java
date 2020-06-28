package dynamic_beat_03;

import java.io.*;

import javazoom.jl.player.*;

public class Music  extends Thread{ //스레드는 하나의 작은 프로그램을 실행한다 생각

	private Player player; //자바 줌 라이브러리의 클래스
	private boolean isLoop; //반복여부
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis; //반복여부
	
	public Music(String name, boolean isLoop) { //곡 제목 무한반복여부
		try {
			this.isLoop=isLoop;
			file = new File(Main.class.getResource("../dynamic_beat_03/Music/"+name).toURI()); //파일주소 가져옴
			fis = new FileInputStream(file);//파일가져옴
			bis = new BufferedInputStream(fis);//버퍼에 담아 읽어옴
			player = new Player(bis); //읽어온 값을 담음
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public int getTime() { //실행되는 음악의 위치를 알려줌(재생 구간?)
		if(player == null) 
			return 0;
		return player.getPosition();
	}
	public void close() { //언제든 곡 종료
		isLoop=false;
		player.close();
		this.interrupt(); // 해당 스레드 중지상태
	}
@Override
	public void run() { //스레드 상속시 무조건 사용하는 함수	
		try {
			do {
				player.play();
				fis = new FileInputStream(file);//파일가져옴
				bis = new BufferedInputStream(fis);//버퍼에 담아 읽어옴
				player = new Player(bis); //읽어온 값을 담음
			} while (isLoop);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

}
	
}
