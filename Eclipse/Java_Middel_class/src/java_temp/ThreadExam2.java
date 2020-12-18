package java_temp;

public class ThreadExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 t1 = new MyThread2("*");
		MyThread2 t2 = new MyThread2("-");
		
		// runnable로 만든 쓰레드는 start 메소드를 사용 못함
		
		Thread thread1 = new Thread(t1); //MyThread2가 Runnable 클래스를 구현하고 있기 때문에 Thread 클래스의 생성자로 넣어주면 된다.
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("main end!!!");
	}
}
