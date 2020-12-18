package java_temp;

public class MyThread2 implements Runnable {

	String str;
	public MyThread2(String str) {
		this.str = str;
	}
	@Override
	public void run() {
		// 자바는 단일 상속만 지원하기 때문에 
		// Runnable 인터페이스로 쓰레드 생성하는 방법도 만들어 놨음
		for(int i = 0; i < 10; i++) {
			System.out.println(str);
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
