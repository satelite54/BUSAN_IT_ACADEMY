package chap04;

import java.util.EmptyStackException;

import chap04.IntStack.OverflowIntStackException;

public class RingBufferQueue {
	private int max;		// ť�� �뷮
	private int front;		// ù ��° ��� Ŀ�� �ε��� ����
	private int rear; 		// �������� ���� ����� �ϳ� ���� �ε��� ����
	private	int num;		// ���� ������ ��
	private int[] que;		// ť ��ü�� �迭
	
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
	
	public int enque(int x) { // ť�� �����͸� ��ť
		if(num >= max)
			return -1;
		que[rear++] = x; // que�� �����͸� ���� rear = +1
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
			System.out.println("ť�� ��� �ֽ��ϴ�.");
		else {
			for(int i = 0; i < num; i++) {
				System.out.print(que[(i + front) % max] + " ");
			}
			System.out.println();
		}
	}
	
	public int search(int x) { // �������� 
		for(int i = 0; i < max; i++) {
			int idx = (i + front) % max; // ť�� �ε����� ����
			if(que[idx] == x) {
				return idx - front + 1; // �ε������� ����Ʈ�� ���� ����. ù ��° ����Ʈ�� �ִ� �����͸� 1�� ����.
			}
		}
		return 0;
	}
}
