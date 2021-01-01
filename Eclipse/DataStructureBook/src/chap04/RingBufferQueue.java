package chap04;

import java.util.EmptyStackException;

import chap04.IntStack.OverflowIntStackException;

public class RingBufferQueue {
	private int max;		// 큐의 용량
	private int front;		// 첫 번째 요소 커서 인덱스 저장
	private int rear; 		// 마지막에 넣은 요소의 하나 뒤의 인덱스 저장
	private	int num;		// 현재 데이터 수
	private int[] que;		// 큐 본체용 배열
	
	public class EmptyInQueueExepetion extends RuntimeException {
		public EmptyInQueueExepetion() {
			
		}
	}
	
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
			
		}
	}
	
	public RingBufferQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int enque(int x) { // 큐에 데이터를 인큐
		if(num >= max)
			return -1;
		que[rear++] = x; // que에 데이터를 놓고 rear = +1
		num++;
		if(rear == max)
			rear = 0;
		return x;
	}
	
	public int deque() {
		if(num <= 0)
			throw new EmptyStackException();
		int x = que[front++];
		num--;
		if(front == max)
			front = 0;
		return x;
	}
	
	public int peek() throws EmptyInQueueExepetion {
		if (num <= 0)
			throw new EmptyInQueueExepetion();
		
		return que[front];
	}
	public int indexOf(int x) {
		for(int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if(que[idx] == x) {
				return idx;
			}
		}
		return -1;
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int capacity() {
		return max;
	}
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num <= 0;
	}
	
	public boolean isFull() {
		return num >= max;
	}
	public void dump() {
		if(num >= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for(int i = 0; i < num; i++) {
				System.out.print(que[(i + front) % max] + " ");
			}
			System.out.println();
		}
	}
	
	public int search(int x) { // 연습문제 
		for(int i = 0; i < max; i++) {
			int idx = (i + front) % max; // 큐의 인덱스를 구함
			if(que[idx] == x) {
				return idx - front + 1; // 인덱스에서 프론트의 값을 뺀다. 첫 번째 프론트에 있는 데이터를 1로 간주.
			}
		}
		return 0;
	}
}
