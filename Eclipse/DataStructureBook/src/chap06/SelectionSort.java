package chap06;

import java.util.Random;

import Array.CArray;

public class SelectionSort {

	static void selectionSort(int[] a, int n) {
		for(int i = 0; i < n - 1; i++) {
			int min = i; //아직 정렬되지 않은 부분의 인덱스
			for(int j = i + 1; j < n; j++) {
				if (a[j] < a[min])
					min = j; // 가장 작은 요소의 인덱스 기록
			}
			swap(a, i, min);
		}
	}
	
	static void swap(int[] a, int first, int min) {
		int temp = 0;
		temp = a[first];
		a[first] = a[min];
		a[min] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		int[] nAry = new int[10];
		for(int i = 0; i < nAry.length; i++) {
			nAry[i] = random.nextInt(nAry.length);
		}
		
		CArray.printAry(nAry);
		selectionSort(nAry, nAry.length);
		CArray.printAry(nAry);
	}
}
