package chap03;

import java.util.Scanner;

public class SeqSearch {
	// 선형 검색
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		
		while(true) {
			if (i == n)
				return -1; // 검색 실패
			if (a[i] == key) {
				return i; // 검색 성공! 인덱스를 반환
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = kb.nextInt();
		int[] x = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]:");
			x[i] = kb.nextInt();
		}
		System.out.print("검색할 값 : ");
		int ky = kb.nextInt();
		
		int idx = seqSearch(x, num, ky);
		
		if(idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		}
		else {
			System.out.println(ky+"은(는) x[" + idx + "]에 있습니다.");
		}
	}
}
