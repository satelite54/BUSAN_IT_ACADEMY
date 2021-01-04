package chap05;

import java.util.Scanner;

public class EuclidGCD {

	static int gcd(int x, int y) {
		if(y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
	
	static int gcd1(int a, int b) {//재귀를 사용하지 않고 유클리드 호제법 사용하기
	    int tmp, n;
	      if(a < b){
	          tmp = a;
	          a = b;
	          b = tmp;
	      }
	      while(b != 0){ //b가 0이 아닌 경우 break
	          n = a%b; // 나머지 넣어줌
	          a = b; // a에 b를 넣고
	          b = n; // b에 n을 넣음
	      }
	      return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수의 최대공약수를 구합니다.");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.printf("두 정수의 최대 공약수는 %d 입니다.", gcd(x, y));
	}

}
