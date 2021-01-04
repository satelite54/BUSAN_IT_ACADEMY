package chap04;

public class Deck { //양방향 대기열 deque 구현
	private int max;
	private int num;
	private int[] deque;
	private int front;
	private int rear; 
	
	public class DequeDataEndException extends RuntimeException {
		public DequeDataEndException() {

		}
	}
	
	public Deck(int capacity) {
		this.deque = new int[capacity];
		max = capacity;
		rear = max - 1;
	}
	
	public int FrontEnque(int x) {
		if(front == rear) {
			throw new DequeDataEndException();
		}
		else {
			deque[front++] = x;
		}
		return x;
	}
	public int RearEnque(int x) {
		if(front == rear) {
			throw new DequeDataEndException();
		}
		else {
			deque[rear--] = x;
		}
		return x;
	}
	
	public void FrontDeque() {
		if(front == rear) {
			throw new DequeDataEndException();
		}
		front++;
	}
	public void RearDeque() {
		if(front == rear) {
			throw new DequeDataEndException();
		}
		rear--;
	}
	public int Frontpeek() {
		return deque[front - 1];
	}
	public int Rearpeek() {
		return deque[rear];
	}
	
	public void dump() {
		for(int i = front - 1; i < - front + rear; i++) {
			System.out.printf(" %d", deque[i]);
		}
		System.out.println();
	}
}
