package Math;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	int g = 1;
	//                     큰 수	   작은 수
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		} else {   // 작은수  큰수를 작은 수로 나눈 수
			return gcd(b, a % b);
		}
	}
}
