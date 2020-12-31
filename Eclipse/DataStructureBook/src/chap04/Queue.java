package chap04;

public class Queue {// 연습문제 4 - Q4 큐를 구현해라
	private int max; // 큐의 길이
	private int num; // 현재 데이터 수
	private int[] que; // 큐 본체
	
	
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
		// 이렇게 되면 복잡도는 O(n)이 된다.
		// 링버퍼로 큐를 만들면 앞쪽으로 배열 요소를 옮기지 않아도 된다.
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
