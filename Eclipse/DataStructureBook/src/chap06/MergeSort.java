package chap06;

import java.util.Arrays;
import java.util.Comparator;

import Array.CArray;

public class MergeSort { // O(nlog(n)) // 병합정렬 
	// 정렬 속도가 비교적 일정하다. 최선 평균 최악 다 nlog(n) 임
	
	
	static int[] src = {4, 1, 2, 7, 3, 9, 10};
	static int[] tmp = new int[src.length];
	
	static class ExData {
		int a;
		
		public ExData(int a) {
			this.a = a;
		}
		
		static final Comparator<ExData> A = new Acomparator();
		
		private static class Acomparator implements Comparator<ExData> {
			@Override
			public int compare(ExData o1, ExData o2) {
				return (o1.a < o2.a) ? 1 : (o1.a > o2.a) ? -1 : 0; // 내림차순 정렬
			}
			
		}
	}
	
	public static void main(String args[]) {
		mergeSort(0, src.length - 1);
		CArray.printAry(src);
		CArray.RandomInt(src, src.length);
		Arrays.sort(src); // 기본 타입 배열은 퀵 정렬;
		CArray.printAry(src);
		CArray.RandomInt(src, src.length);
		Integer[] IAry = new Integer[src.length];
		for(int i = 0; i < src.length; i++) {
			IAry[i] = src[i];
		}
		// 보통 자연정렬이 필요한 자바 기본 객체들은 comparable 인터페이스를 구현하고 있음.
		//자연정렬 필요한 레퍼 클래스 정렬 Arrays.sort(IAry); // 객체 타입 배열은 병합 정렬
		Arrays.sort(IAry);
		for(int i = 0; i < src.length; i++) {
			System.out.println(IAry[i]);
		}
		System.out.println();
		
		ExData[] data = {new ExData(5), new ExData(1), new ExData(3), new ExData(8)};
		
		
		Arrays.sort(data, ExData.A); // 자연정렬이 필요하지 않은 객체 배열들은 Comparator 인터페이스의 구현을 통해 정렬한다.
		
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i].a);
		}
	}
	
	public static void mergeSort(int start, int end) {
		if (start<end) {
			int mid = (start+end) / 2;
			
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			int p = start; 
			int q = mid + 1; 
			int idx = p; 
			
			while (p <= mid || q <= end) {
				
				if (q>end || (p<=mid && src[p] < src[q])) {
					tmp[idx++] = src[p++]; 
				} else { 
					tmp[idx++] = src[q++]; 
					}
				} for (int i=start;i<=end;i++) {
					src[i]=tmp[i]; 
					}
				} 
		}
}
