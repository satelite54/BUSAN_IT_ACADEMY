package Que;

public class DequeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deque deque = new Deque(10);
		
		deque.push_front(1);
		int x = deque.back();
		System.out.println(x);
		deque.push_back(10);
		int y = deque.back();
		System.out.println(y);
		deque.push_back(10);
		int z = deque.back();
		
		deque.dump();
		deque.push_front(3);
		deque.dump();
		
		int iu = deque.pop_front();
		System.out.println(iu);
		deque.pop_front();
		deque.pop_front();
		deque.dump();
	}

}
