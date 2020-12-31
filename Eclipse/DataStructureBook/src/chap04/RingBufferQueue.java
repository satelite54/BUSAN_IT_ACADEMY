package chap04;

import chap04.IntStack.OverflowIntStackException;

public class RingBufferQueue {
	private int max;		// 큐의 용량
	private int front;		// 첫 번째 요소 커서 인덱스 저장
	private int rear; 		// 마지막에 넣은 요소의 하나 뒤의 인덱스 저장
	private	int num;		// 현재 데이터 수
	private int[] que;		// 큐 본체용 배열
	
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
}
