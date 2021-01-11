package chap06;

import Array.CArray;

public class FrequencySort {

    static void frequencySort(int[] a, int n, int max) {
        int[] f = new int[max + 1];        // ���� ����
        int[] b = new int[n];              // �۾��� ���� �迭
        
        for (int i = 0;        i < n;        i++) f[a[i]]++;            // 1�ܰ�
        for (int i = 1;        i <= max;     i++) f[i] += f[i - 1];     // 2�ܰ�
        for (int i = n - 1;    i >= 0;       i--) b[--f[a[i]]] = a[i];  // 3�ܰ�
        for (int i = 0;        i < n;        i++) a[i] = b[i];          // 4�ܰ�
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nAry = new int[20];
		CArray.RandomInt(nAry, nAry.length);
		CArray.printAry(nAry);
		int max = nAry[0];
		for(int i = 1; i < nAry.length; i++) {
			if(nAry[i] > max) max = nAry[i];
		}
		
		frequencySort(nAry, nAry.length, max);
		CArray.printAry(nAry);
	}

}
