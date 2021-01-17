package Math;

public class PrimeNumber {
	// �Ҽ��� ����� 1�� �ڱ� �ڽ� �ۿ� ���� ��
	// ���� N�� �Ҽ��� �Ƿ��� 2���� ũ�ų� ���� N - 1���� �۰ų� ���� �ڿ����� ������ �������� �ȵȴ�.
	
	// N�� �Ҽ��� �ƴ϶�� N = a * b�� ��Ÿ���� ���� ����
	
	// N������ �Ҽ��� ã�Ƴ��� �˰��� �ַ��佺�׳׽��� ü
	// 100������ �Ҽ��� ã�Ƴ��� ���
	// 2�� ����� ��� �����.
	// �������� ���� �� �߿��� ���� ���� ���� �����.
	// �ݺ��ϴٰ� 11 * 11�� 100�� �ѱ� ������ �迭�� �����ִ� ���� �Ҽ��� �ȴ�.
	
	
	// ��� �Ҽ��� 6n���� ������ 1�̳� 5�� �ȴ� �˾Ƶ� ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean prime1(int n) { // N�� �Ҽ�����? �Ǻ� O(N)
		if(n < 2)
			return false;
		
		for(int i = 2; i <= n - 1; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean prime2(int n) {
		if(n < 2) {
			return false;
		}
		
		for(int i = 2; i*i <= n ; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] SieveofEratosthenes(int N) { //N������ �Ҽ��� ���ϴ� �˰��� �����佺�׳׽��� ü
		int[] prime = new int[N];
		int pn = 0; // �Ҽ��� ����
		boolean[] check = new boolean[N + 1]; // ���������� true
		int n = 100; // 100���� �Ҽ�
		
		for(int i = 2; i <= n; i++) {
			if(check[i] == false) {// �������� �ʾ��� ���
				prime[pn++] = i;
				for(int j = i + i; j <= n; j += i) {
					check[j] = true;
				}
			}
		}
		return prime;
	}
	
	//�������� ����
	// 2���� ū ��� ¦���� �μҼ��� ������ ǥ�� �����ϴ�.
	// ���� ���ڿ� 3�� ���ϸ� 
	// 5���� ū ��� Ȧ���� �� �Ҽ��� ������ ǥ�� �����ϴ�.
	// ���� ������� ���� ����
	// 10^18���Ͽ����� ���� ���� ����Ǿ� �ִ�.
	
	// �����佺�׳׽��� ü���� check[N - b] == false����? �˻� ���ָ� �ȴ�.
	public static int[] Goldbachsconjecture() {
		return new int[1];
	}
}
