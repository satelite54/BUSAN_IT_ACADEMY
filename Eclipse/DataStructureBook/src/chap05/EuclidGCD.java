package chap05;

import java.util.Scanner;

public class EuclidGCD {

	static int gcd(int x, int y) {
		if(y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
	
	static int gcd1(int a, int b) {//��͸� ������� �ʰ� ��Ŭ���� ȣ���� ����ϱ�
	    int tmp, n;
	      if(a < b){
	          tmp = a;
	          a = b;
	          b = tmp;
	      }
	      while(b != 0){ //b�� 0�� �ƴ� ��� break
	          n = a%b; // ������ �־���
	          a = b; // a�� b�� �ְ�
	          b = n; // b�� n�� ����
	      }
	      return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ������ �ִ������� ���մϴ�.");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.printf("�� ������ �ִ� ������� %d �Դϴ�.", gcd(x, y));
	}

}
