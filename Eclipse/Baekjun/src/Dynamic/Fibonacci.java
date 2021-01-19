package Dynamic;

public class Fibonacci {
	// ���̳��� ���α׷����� ��ȭ���� ����鼭 Ǯ����Ѵ�.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = fibonacci(3);
		System.out.println(n);
	}
	
	public static int fibonacci(int n) { // bottom UP ���� ���� �� �����  O(N)
		int[] nAry = new int[n + 1];
		nAry[0] = 0;
		nAry[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			nAry[i] = nAry[i - 1] + nAry[i - 2];
		}
		return nAry[n];
	}
}
