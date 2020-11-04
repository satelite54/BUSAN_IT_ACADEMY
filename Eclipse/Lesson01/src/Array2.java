import java.util.Scanner;

public class Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] nArray = new int[n];
		for(int i = 0; i < n; i++) {
			nArray[i] = kb.nextInt();
		}
		kb.close();
		
		int sum = 0, max = nArray[0];
		for(int j = 0; j < n; j++) {
			sum += nArray[j];
			if(nArray[j] > max) max = nArray[j];
		}
		System.out.println("The sum is" + sum + "and the maximum is" + max);	
	}

}
