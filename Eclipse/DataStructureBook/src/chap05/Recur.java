package chap05;

import java.util.Scanner;

import chap04.IntStack;

public class Recur {

	static void recur(int n) {
		if(n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);// 꼬리재귀의 제거
			// 인자로 n - 2를 전달하여 recur 메서드를 호출한다.
			// n의 값을 n - 2로 업데이트하고 메서드의 시작 지점으로 되돌아간다.
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
		System.out.print("정수를 입력하세요. : ");
		int x = sc.nextInt();
		
		recur1(x);
	}

}
