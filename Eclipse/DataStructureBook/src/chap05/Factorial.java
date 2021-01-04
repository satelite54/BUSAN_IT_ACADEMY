package chap05;

import java.util.Scanner;

public class Factorial {

	static int factorial(int n) {
		if(n > 0) {
			return n * factorial(n - 1);
		}
		else {
			return 1;
		}
	}
	
	static int factorial1(int x) {// ��͸� ������� �ʰ� ���丮�� �����ϱ�
		
		int result = 1;
		while(x != 0) {
			result *= x;
			x--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(x + "�� ���丮���� " + factorial(x) +"�Դϴ�.");
	}

}
