package Problem;

import java.util.Scanner;

public class C1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] d = new int[n + 1];
		
		for(int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + 1;// N -> (N - 1)
			if(i%2 == 0 && d[i] > d[i/2] + 1) {
				d[i] = d[i/2] + 1;
			}
			if(i%3 == 0 && d[i] > d[i/3] + 1) {
				d[i] = d[i/3] + 1;
			}
		}

		for(int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
	}
}
