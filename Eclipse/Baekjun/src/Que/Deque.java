package Que;

public class Deque {  // 2021/01/13 김태헌
	private int[] deque;
	private int max; // 데이터 최대 개수
	private int front_ptr; // 프론트 ptr
	private int front_num; // 프론트에 입력된 데이터 개수
	private int back_ptr;  // 백(리어) ptr
	private int back_num; // 백에 입력된 데이터 개수
	
	public Deque(int capacity) {
		this.deque = new int[capacity];
		this.front_ptr = 0;
		this.front_num = 0;
		this.back_ptr = capacity - 1;
		this.back_num = 0;
		this.max = capacity;
	}
	public class DequeOverflowException extends RuntimeException { // 런타임 예외 처리
		public DequeOverflowException() {

		}
	}
	public class DequeHaveNoDataException extends RuntimeException {
		public DequeHaveNoDataException() {

		}
	}
	
	public boolean push_front(int x) {
		if(front_num + back_num == max) {
			throw new DequeOverflowException();
		} else {
			deque[front_ptr++] = x;
			front_num++;
			return true;
		}
	}
	public boolean push_back(int x) {
		if(front_num + back_num == max) {
			throw new DequeOverflowException();
		} else {
			deque[back_ptr--] = x;
			back_num++;
			return true;
		}
	}
	
	public int pop_front() {
		if(front_num + back_num == 0) {
			throw new DequeHaveNoDataException();
		} else {
			if(front_ptr == 0) {
				int x = deque[back_ptr + 1];
				deque[back_ptr + 1] = 0;
				back_ptr++;
				back_num--;
				return x;
			} else {
				int x = deque[front_ptr - 1];
				deque[front_ptr - 1] = 0;
				front_ptr--;
				front_num--;
				return x;
			}
		}
	}
	public int pop_back() {
		if(front_num + back_num == 0) {
			throw new DequeHaveNoDataException();
		} else {
			if(back_ptr == max - 1) {
				int x = deque[front_ptr - 1];
				deque[front_ptr - 1] = 0;
				front_ptr++;
				front_num--;
				return x;
			} else {
				int x = deque[back_ptr + 1];
				deque[back_ptr + 1] = 0;
				back_ptr--;
				back_num--;
				return x;
			}
		}
	}
	public int front() {
		if(front_num + back_num == 0) {
			throw new DequeHaveNoDataException();
		} else {
			if(front_ptr == 0) {
				return deque[front_ptr - 1];
			} else {
				return deque[back_ptr + 1];
			}
		}
	}
	
	public int back() {
		if(front_num + back_num == 0) {
			throw new DequeHaveNoDataException();
		} else {
			if(back_ptr == max - 1) {
				return deque[front_ptr - 1];
			} else {
				return deque[back_ptr + 1];
			}
		}
	}
	
	public void dump() { // 덱 전체 데이터 출력
		for(int i = 0; i < deque.length; i++) {
			System.out.print(deque[i] + " ");
		}
		System.out.println();
	}
}
