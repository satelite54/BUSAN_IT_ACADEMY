package chap04;

public class QueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue que = new Queue(5);
		
		que.inQueue(5);
		que.inQueue(4);
		que.inQueue(3);
		que.dumped();
		
		que.deQueue();
		que.dumped();
	}

}
