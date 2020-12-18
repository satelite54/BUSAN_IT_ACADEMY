package java_temp;

public class theard_th extends Thread { // Thread 클래스를 상속받아서 쓰레드 구현하는 방법
//jvm은 프로세스 -> 여러개의 쓰레드로 이루어짐
//
	String str;
	public theard_th(String str) {
		this.str = str;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			System.out.println(str);
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
	}

}
