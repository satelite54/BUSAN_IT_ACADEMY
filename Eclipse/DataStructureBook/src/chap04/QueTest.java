package chap04;

public class QueTest {

	public static void main(String[] args) {
		RingBufferQueue que1 = new RingBufferQueue(10);
		
		que1.enque(1);
		que1.enque(2);
		que1.enque(3);
		que1.enque(4);
		que1.enque(5);
		que1.enque(6);
		que1.enque(7);
		que1.enque(8);
		que1.enque(9);
		que1.enque(10);
		
		int a = que1.search(6);
		System.out.println(a);
	}

}
