package Math;

import java.util.Scanner;

public class CRemainder {

	// (A + B) % C = ((A % C) + (B % C)) % C
	// (A * B) % C = ((A % C) * (B % C)) % C
	// (A - B) % C = ((A % C) - (B % C) + C ) % C     -C < __ < C      0 < __ < 2sC     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println((A + B) % C);
		System.out.println((A % C + B % C) % C);
		System.out.println((A * B) % C);
		System.out.println((A % C * B % C) % C);
	}
}
