package chap04;

public class Queue {// �������� 4 - Q4 ť�� �����ض�
	private int max; // ť�� ����
	private int num; // ���� ������ ��
	private int[] que; // ť ��ü
	
	
	public Queue(int QueLength) {
		this.que = new int[QueLength];
		this.max = QueLength;
	}
	
	public boolean inQueue(int n) {
		if(num == max) {
			return false;
		}
		que[num] = n;
		num++;
		return true;
	}
	
	public int deQueue() {
		if(num == 0) {
			return -1;
		}
		int result = que[0];
		for(int i = 1; i < que.length; i++) {
			que[i - 1] = que[i];
		}
		// �̷��� �Ǹ� ���⵵�� O(n)�� �ȴ�.
		// �����۷� ť�� ����� �������� �迭 ��Ҹ� �ű��� �ʾƵ� �ȴ�.
		num--;
		return result;
	}
	public void dumped() {
		for(int i = 0; i < num; i++) {
			System.out.print(que[i] + " ");			
		}
		System.out.println();
	}
}
