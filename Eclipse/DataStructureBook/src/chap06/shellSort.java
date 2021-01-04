package chap06;

import java.util.Random;

import Array.CArray;

public class shellSort {

	static void shellSort(int[] a, int n) {
		for(int h = n / 2; h > 0; h /= 2) {
			for(int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for(j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
				}
				a[j + h] = tmp;
			}
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
		shellSort(nAry, nAry.length);
		CArray.printAry(nAry);
	}

}
