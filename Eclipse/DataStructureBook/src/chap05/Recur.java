package chap05;

import java.util.Scanner;

import chap04.IntStack;

public class Recur {

	static void recur(int n) {
		if(n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);// ��������� ����
			// ���ڷ� n - 2�� �����Ͽ� recur �޼��带 ȣ���Ѵ�.
			// n�� ���� n - 2�� ������Ʈ�ϰ� �޼����� ���� �������� �ǵ��ư���.
		}
	}
	
	static void recur1(int n) {
		IntStack s = new IntStack(n);
		
		while(true) {
			if(n > 0) {
				s.push(n);
				n = n - 1;
				continue;
			}
			if(s.isEmpty() != true) {
				n = s.pop();
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���. : ");
		int x = sc.nextInt();
		
		recur1(x);
	}

}
