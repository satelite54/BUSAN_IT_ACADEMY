import java.util.Scanner;

public class code16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int n = 2; n <= 100000; n++) {
			if (isPrime(n))
				System.out.println(n);
		}
		
		Scanner kb = new Scanner(System.in);
	}
	
	static boolean isPrime (int k) {
		if(k < 2)
			return true;
		for (int i = 2; i*i<=k; i++)
			if(k % i == 0)
				return false;
		return true;
	}
}
