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
	// ���ÿ� X�� Ǫ��
	public int push(int x) throws OverflowIntStackException {
		if(ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	// ���ÿ��� �����͸� ��(���� �ִ� �����͸� ����)
	public int pop() throws EmptyIntStackException {
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	// ���ÿ��� �����͸� ��ũ(���� �ִ� �����͸� ���� ��)
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}
	
	// ���ÿ��� x�� ã�� �ε��� ��ȯ
	public int indxOf(int x) {
		for(int i = ptr - 1; i >= 0; i--) {
			if(stk[i] == x)
				return i;
		}
		return -1;
	}
	// ������ ���
	public void clear() {
		ptr = 0;
	}
	// ������ �뷮�� ��ȯ
	public int capacity() {
		return max;
	}
	// ���ÿ� �׿� �ִ� ������ �� ��ȯ
	public int size() {
		return ptr;
	}
	// ������ ��� �ִ���?
	public boolean isEmpty() {
		return ptr <= 0;
	}
	// ������ ���� ���ִ���?
	public boolean isFull() {
		return ptr >= max;
	}
	// ���ø��� ��� ������ ���
	public void dump() {
		if(ptr <= 0) {
			System.out.println("������ ��� �ֽ��ϴ�.");
		} else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
}
