package chap03;

import java.util.Arrays;

import Array.CArray;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[100];
		CArray Ary = new CArray();
		for(int i = 0; i < 100; i++) {
			a[i] = Ary.RandomInt(100);	
		}
		int result1 = 0;
		int result2 = 0;
		result1 = BnSearch(a, 100, a[3]);
		result2 = Arrays.binarySearch(a, a[3]);
		//Arrays Ŭ������ ����Ž�� �޼ҵ�
		System.out.println(result1);
		System.out.println(result2);
	}

	public static int BnSearch(int ar[], int len, int target){
		// ���� Ž�� �˰��� �ݺ��� ����
		// ã�� ���ڰ� ������ ã�� ������ �ε��� ���� ������ -1 ����

	    int firstidx = 0;
	    int lastidx = len - 1;
	    int mididx = 0;
	    // first�� last�� ���� ������ �ݺ��ϴ� ����
	    // while(first < last)�̸� ������ �ϳ��� ��������
	    // �˻����� �ʰ� ����Ǳ� �����̴�.
	    while (firstidx <= lastidx){
	        mididx = (firstidx + lastidx) / 2; // �߾� ����� �ε���
	        if (ar[mididx] == target){ // ã�� ���̶� �߾� ����� ���� ������
	            return mididx; // �߾� ��� �ε��� ����
	        }
	        else{
	            if (ar[mididx] > target) // �߾� ����� ������ Ÿ�� ���� ������
	                lastidx = mididx - 1; // �˻� ������ ���� ������ ���δ�.
	            else if(ar[mididx] <= target)
	                firstidx = mididx + 1; // �˻� ������ ���� ������ ���δ�.
	        } 
	    }
	    return -1;
	}
}
