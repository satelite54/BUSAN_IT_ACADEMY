package java_temp;

public class ThreadExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 t1 = new MyThread2("*");
		MyThread2 t2 = new MyThread2("-");
		
		// runnable�� ���� ������� start �޼ҵ带 ��� ����
		
		Thread thread1 = new Thread(t1); //MyThread2�� Runnable Ŭ������ �����ϰ� �ֱ� ������ Thread Ŭ������ �����ڷ� �־��ָ� �ȴ�.
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("main end!!!");
	}
}
