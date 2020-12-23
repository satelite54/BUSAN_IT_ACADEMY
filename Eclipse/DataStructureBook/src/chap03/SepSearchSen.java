package chap03;

import java.util.Scanner;
// ���� �˻� (���ʹ�)

public class SepSearchSen {
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		
		a[n] = key;
		
		while(true) {
			if(a[i] == key) // �˻� ����!
				break;
			i++;
		}
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		int num = kb.nextInt();
		int[] x = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]:");
			x[i] = kb.nextInt();
		}
		System.out.print("�˻��� �� : ");
		int ky = kb.nextInt();
		
		int idx = seqSearch(x, num, ky);
		
		if(idx == -1) {
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		}
		else {
			System.out.println(ky+"��(��) x[" + idx + "]�� �ֽ��ϴ�.");
		}
	}
}
