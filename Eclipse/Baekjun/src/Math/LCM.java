package Math;

import java.util.Scanner;

public class LCM {
	// �� ���� ���� ����  �ִ����� * �ּҰ������ ����.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int Big = gcd(A, B);
		System.out.println(Big);
		System.out.println(A * B / Big);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		else {
			return gcd(b , a % b);
		}
	}
	
}
