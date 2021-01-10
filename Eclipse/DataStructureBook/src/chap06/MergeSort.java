package chap06;

import java.util.Arrays;
import java.util.Comparator;

import Array.CArray;

public class MergeSort { // O(nlog(n)) // �������� 
	// ���� �ӵ��� ���� �����ϴ�. �ּ� ��� �־� �� nlog(n) ��
	
	
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
				return (o1.a < o2.a) ? 1 : (o1.a > o2.a) ? -1 : 0; // �������� ����
			}
			
		}
	}
	
	public static void main(String args[]) {
		mergeSort(0, src.length - 1);
		CArray.printAry(src);
		CArray.RandomInt(src, src.length);
		Arrays.sort(src); // �⺻ Ÿ�� �迭�� �� ����;
		CArray.printAry(src);
		CArray.RandomInt(src, src.length);
		Integer[] IAry = new Integer[src.length];
		for(int i = 0; i < src.length; i++) {
			IAry[i] = src[i];
		}
		// ���� �ڿ������� �ʿ��� �ڹ� �⺻ ��ü���� comparable �������̽��� �����ϰ� ����.
		//�ڿ����� �ʿ��� ���� Ŭ���� ���� Arrays.sort(IAry); // ��ü Ÿ�� �迭�� ���� ����
		Arrays.sort(IAry);
		for(int i = 0; i < src.length; i++) {
			System.out.println(IAry[i]);
		}
		System.out.println();
		
		ExData[] data = {new ExData(5), new ExData(1), new ExData(3), new ExData(8)};
		
		
		Arrays.sort(data, ExData.A); // �ڿ������� �ʿ����� ���� ��ü �迭���� Comparator �������̽��� ������ ���� �����Ѵ�.
		
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
