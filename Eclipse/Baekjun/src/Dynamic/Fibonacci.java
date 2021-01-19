package Dynamic;

public class Fibonacci {
	// 다이나믹 프로그래밍은 점화식을 세우면서 풀어야한다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = fibonacci(3);
		System.out.println(n);
	}
	
	public static int fibonacci(int n) { // bottom UP 보통 바텀 업 방식은  O(N)
		int[] nAry = new int[n + 1];
		nAry[0] = 0;
		nAry[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			nAry[i] = nAry[i - 1] + nAry[i - 2];
		}
		return nAry[n];
	}
}
