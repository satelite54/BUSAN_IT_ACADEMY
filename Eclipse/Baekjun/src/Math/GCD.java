package Math;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	int g = 1;
	//                     ū ��	   ���� ��
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		} else {   // ������  ū���� ���� ���� ���� ��
			return gcd(b, a % b);
		}
	}
}
