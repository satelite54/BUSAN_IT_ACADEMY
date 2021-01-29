package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class etc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer N = 1;
		Integer O = 2;
		
		swap(N, O);
		System.out.println(N);// intValue가 자동으로 되면서 
		System.out.println(O);// intValue
		System.out.println("////////////////////////////");
	}
	
	public static void swap(Integer N, Integer O) {
		Integer temp = N;
		N = O;
		O = temp;//n:2, temp : 1, o :1
	}
}
