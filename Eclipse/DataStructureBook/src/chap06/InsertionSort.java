package chap06;

import java.util.Random;
import java.util.Scanner;

import Array.CArray;

public class InsertionSort {

	static void insertionSort(int[] a, int n) {
		// tmp <- a[i]
		// a[0] .... a[n - 1]의 알맞은 곳에 tmp를 삽입ㄴ
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
