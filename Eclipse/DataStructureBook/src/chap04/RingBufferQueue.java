package chap04;

import chap04.IntStack.OverflowIntStackException;

public class RingBufferQueue {
	private int max;		// ť�� �뷮
	private int front;		// ù ��° ��� Ŀ�� �ε��� ����
	private int rear; 		// �������� ���� ����� �ϳ� ���� �ε��� ����
	private	int num;		// ���� ������ ��
	private int[] que;		// ť ��ü�� �迭
	
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
}
