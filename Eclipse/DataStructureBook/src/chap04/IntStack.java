package chap04;

public class IntStack {

	private int max;
	private int ptr;
	private int[] stk;
	
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
			
		}
	}
	
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
			
		}
	}
	
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	// 스택에 X를 푸시
	public int push(int x) throws OverflowIntStackException {
		if(ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	// 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
	public int pop() throws EmptyIntStackException {
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	// 스택에서 데이터를 피크(정상에 있는 데이터를 들어다 봄)
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}
	
	// 스택에서 x를 찾아 인덱스 반환
	public int indxOf(int x) {
		for(int i = ptr - 1; i >= 0; i--) {
			if(stk[i] == x)
				return i;
		}
		return -1;
	}
	// 스택을 비움
	public void clear() {
		ptr = 0;
	}
	// 스텍의 용량을 반환
	public int capacity() {
		return max;
	}
	// 스택에 쌓여 있는 데이터 수 반환
	public int size() {
		return ptr;
	}
	// 스택이 비어 있는지?
	public boolean isEmpty() {
		return ptr <= 0;
	}
	// 스택이 가득 차있는지?
	public boolean isFull() {
		return ptr >= max;
	}
	// 스택만의 모든 데이터 출력
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
		} else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
}
