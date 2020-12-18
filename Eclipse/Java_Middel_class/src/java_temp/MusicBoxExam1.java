package java_temp;

public class MusicBoxExam1 {
// 공유 객체 : 하나의 객체를 여러개의 쓰레드가 동시에 사용하는 것을 의미
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicBox box = new MusicBox();
		MusicPlayer kang = new MusicPlayer(1, box);
		MusicPlayer kim = new MusicPlayer(2, box);
		MusicPlayer lee = new MusicPlayer(3, box);
		kang.start();
		kim.start();
		lee.start();
	}

}
