
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class C2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int n = Integer.parseInt(sc.next());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sc.next());
		}
		sc.close();
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			bw.append(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
