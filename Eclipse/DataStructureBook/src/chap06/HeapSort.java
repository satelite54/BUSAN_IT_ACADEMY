package chap06;

import java.util.Arrays;

import Array.CArray;

public class HeapSort {

	public static void heapify(int array[], int n, int i) {
	    int p = i;
	    int l = i * 2 + 1; //부모기준 왼쪽자식 노드 인덱스
	    int r = i * 2 + 2; //부모기준 오른쪽자식 노드 인덱스
	 
	    if (l < n && array[p] < array[l]) {
	        p = l;
	    }
	 
	    if (r < n && array[p] < array[r]) {
	        p = r;
	    }
	 
	    if (i != p) {
	        swap(array, p, i);
	        heapify(array, n, p);
	    }
	}
	 
	public static void heapSort(int[] array) {
	    int n = array.length;
	 
	    // init, max heap
	    for (int i = n / 2 - 1; i >= 0; i--) { // 부모 인덱스 위치
	        heapify(array, n, i); // 배열을 힙으로 바꿈
	    }
	 
	    // for extract max element from heap
	    for (int i = n - 1; i > 0; i--) {
	        swap(array, 0, i);
	        heapify(array, i, 0); // 요소가 하나 제거된 후 다시 최대 힙을 구성하기 위함.
	    }
	}
	 
	public static void swap(int[] array, int a, int b) {
	    int temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nAry = new int[20];
		CArray.RandomInt(nAry, nAry.length);
		heapSort(nAry);
		Arrays.toString(nAry);
	}
}
