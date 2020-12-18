package java_temp;

public class MusicBox {
	public synchronized void playMusicA() { // 여러개의 객체들이 공유객체를 같이 사용할 경우
		// 먼저 실행 되면 해당 객체의 사용권을 얻게 된다.
		// synchronized 키워드가 이런 역할을 한다.
		// 실행이 되면 모니터링 락을 얻게 된다.
		for(int i = 0; i < 10; i++) {
			System.out.println("신나는 음악!!!");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public synchronized void playMusicB() {
		for(int i = 0; i < 10; i++) {
			System.out.println("슬픈 음악 !!!");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void playMusicC() {// 다른 스레드들이 모니터링 락을 획득해도 여기는 synchronized 키워드가 없어 자유롭게 실행된다.
		for(int i = 0; i < 10; i++) {
			synchronized (this) { //현재 객체가 모니터링 락을 가질 수 있을 때 모니터링을 가지게 해서 동기화 하겠다라는 뜻.
				System.out.println("카페 음악!!!");
			}			
//			System.out.println("카페 음악!!!");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// 부분부분만 synchronized가 가능하다.
}
