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
//		Arrays.sort(ndata); ���� �Լ�
		bubblesort(n, ndata);
		for(int i = 0; i < n; i++) {
			System.out.println(ndata[i]);
		}
	}
	static void bubblesort(int n, int[] ndata) { // ���� ���� �˰���
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
	// ȣ���� �Ǹ� ������ ���簡 �ȴ�. ����� ������ �����ص� ���� �������� ������ ����
	// CallbyReference
	// ������ ���� �����ؼ� ���� ���� ���� ���� 
	// C++������ CallbyReferece�� �����ϳ� Java, C������ �������� �ʴ´�.
	
	// �迭�� ������Ƽ�� Ÿ�� �Ű������� �Ѱ��ָ� Callbyreference;
	// non primitive Ÿ�� �Űܺ����� �Ѱ��ָ� Callbyreference
}
