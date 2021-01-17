package Math;

public class PrimeNumber {
	// 소수는 약수가 1과 자기 자신 밖에 없는 수
	// 정수 N이 소수가 되려면 2보다 크거나 같고 N - 1보다 작거나 같은 자연수로 나누어 떨어지면 안된당.
	
	// N이 소수가 아니라면 N = a * b로 나타내는 것이 가능
	
	// N이하의 소수를 찾아내는 알고리즘 애러토스테네스의 체
	// 100이하의 소수를 찾아내는 경우
	// 2의 배수를 모두 지운다.
	// 지워지지 않은 수 중에서 가장 작은 수를 지운다.
	// 반복하다가 11 * 11은 100을 넘기 때문에 배열에 남아있는 수가 소수가 된다.
	
	
	// 모든 소수는 6n으로 나누면 1이나 5가 된다 알아둘 것
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean prime1(int n) { // N이 소수인지? 판별 O(N)
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
	
	public static int[] SieveofEratosthenes(int N) { //N이하의 소수를 구하는 알고리즘 에라토스테네스의 체
		int[] prime = new int[N];
		int pn = 0; // 소수의 개수
		boolean[] check = new boolean[N + 1]; // 지워졌으면 true
		int n = 100; // 100까지 소수
		
		for(int i = 2; i <= n; i++) {
			if(check[i] == false) {// 지워지지 않았을 경운
				prime[pn++] = i;
				for(int j = i + i; j <= n; j += i) {
					check[j] = true;
				}
			}
		}
		return prime;
	}
	
	//골드바흐의 추측
	// 2보다 큰 모든 짝수는 두소수의 합으로 표현 가능하다.
	// 위의 문자에 3을 더하면 
	// 5보다 큰 모든 홀수는 세 소수의 합으로 표현 가능하다.
	// 아직 증명되지 않은 문제
	// 10^18이하에서는 참인 것이 증명되어 있다.
	
	// 에라토스테네스의 체에서 check[N - b] == false인지? 검사 해주면 된다.
	public static int[] Goldbachsconjecture() {
		return new int[1];
	}
}
