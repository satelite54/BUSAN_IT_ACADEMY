package chap04;

import chap04.IntStack.EmptyIntStackException;
import chap04.IntStack.OverflowIntStackException;

public class Gstack<E extends Object> {
	private int max;
	private int ptr;
	private E[] stk;
	
//	public class EmptyIntStackException extends RuntimeException {
//		public EmptyIntStackException() {
//			
//		}
//	}
//	
//	public class OverflowIntStackException extends RuntimeException {
//		public OverflowIntStackException() {
//			
//		}
//	}
	
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = (E[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	// ���ÿ� X�� Ǫ��
	public E push(E x) {
		if(this.isFull()) {
			System.out.println("Generic Stack is full");
			return x;
		}
		return stk[ptr++] = x;
	}
	// ���ÿ��� �����͸� ��(���� �ִ� �����͸� ����)
	public E pop() {
		if(this.isEmpty()) {
			System.out.println("Generic Stack is Empty");
		}
		return stk[--ptr];
	}
	
	// ���ÿ��� �����͸� ��ũ(���� �ִ� �����͸� ���� ��)
	public E peek() {
		if (this.isEmpty())
			System.out.println("Generic Stack is Empty");
		return stk[ptr - 1];
	}
	
	// ���ÿ��� x�� ã�� �ε��� ��ȯs
	public int indxOf(E x) {
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
