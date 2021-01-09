package chap06;

import java.util.Random;
import java.util.Scanner;

import Array.CArray;

public class InsertionSort {

	static void insertionSort(int[] a, int n) {
		// tmp <- a[i]
		// a[0] .... a[n - 1]의 알맞은 곳에 tmp를 삽입ㄴ
		//선택한 요소를 그보다 더 앞쪽의 알맞은 위치에 '삽입하는' 작업을 반복하여 정렬하는 알고리즘
//		 A. 정렬을 마쳤거나 정렬을 마친 상태에 가까우면 정렬 속도가 매우 빨라집니다(장점)
//
//		 B. 삽입할 위치가 멀리 떨어져 있으면 이동(대입)해야 하는 횟수가 많아집니다(단점)
		for(int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			for(j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		int[] nAry = new int[10];
		for(int i = 0; i < nAry.length; i++) {
			nAry[i] = random.nextInt(nAry.length);
		}
		CArray.printAry(nAry);
		insertionSort(nAry, nAry.length);
		CArray.printAry(nAry);
	}

}
