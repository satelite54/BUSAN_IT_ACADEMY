package chap06;

import java.util.Arrays;

import Array.CArray;

public class HeapSort {

	public static void heapify(int array[], int n, int i) {
	    int p = i;
	    int l = i * 2 + 1; //�θ���� �����ڽ� ��� �ε���
	    int r = i * 2 + 2; //�θ���� �������ڽ� ��� �ε���
	 
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
	    for (int i = n / 2 - 1; i >= 0; i--) { // �θ� �ε��� ��ġ
	        heapify(array, n, i); // �迭�� ������ �ٲ�
	    }
	 
	    // for extract max element from heap
	    for (int i = n - 1; i > 0; i--) {
	        swap(array, 0, i);
	        heapify(array, i, 0); // ��Ұ� �ϳ� ���ŵ� �� �ٽ� �ִ� ���� �����ϱ� ����.
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
