import java.util.Arrays;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class bubblesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		
		int[] ndata = new int[n];
		for(int i = 0; i < n; i++) {
			ndata[i] = kb.nextInt();
		}
		kb.close();
//		Arrays.sort(ndata); 정렬 함수
		bubblesort(n, ndata);
		for(int i = 0; i < n; i++) {
			System.out.println(ndata[i]);
		}
	}
	static void bubblesort(int n, int[] ndata) { // 버블 정렬 알고리즘
		for(int i = n - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				
				if(ndata[j] > ndata[j+1]) {
					//swap ndata[j] and ndata[j+1]
					//// actual parameter
					swap( ndata[j], ndata[j+1]);
//					int tmp = ndata[j];
//					ndata[j]= ndata[j + 1];
//					ndata = tmp;
				}
			}
		}
	}                // formal parameter
	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	// CallbyValue
	// 호출이 되면 변수가 복사가 된다. 복사된 변수를 변경해도 원래 변수에는 영향이 없음
	// CallbyReference
	// 변수에 직접 참조해서 직접 변수 값을 변경 
	// C++에서는 CallbyReferece를 지원하나 Java, C에서는 지원하지 않는다.
	
	// 배열을 프리미티브 타입 매개변수를 넘겨주면 Callbyreference;
	// non primitive 타입 매겨변수를 넘겨주면 Callbyreference
}
