package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SelectionSort {
	// �迭���� ���� ������ �����ؼ� ������ ������ �ʹ�!
	
	// Ư���� �˰����� ����ð��� �����ϰ� ǥ���� ���� ��� ǥ����̴�.
	// ���� ������ ��ȿ������ �˰���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] Ary = {6,5,4,7,2,8,1,9,3,10}; 
		SelectionSort(Ary);
		for (int i = 0; i < Ary.length; i++) {
			System.out.print(Ary[i] + " ");
		}
	}
	
	public static int[] SelectionSort(int[] arr) {
		int i, j, min, index = 0, temp;
		// min�� �ּҰ��� �����ϱ� ���� ����
		// index�� �ٲ������� index�� �����ϱ� ���� ����
		for(i = 0; i < 10; i++) {
			min = 99999999;// ��� ���ҵ� ���� ū��;
			for(j = i; j < 10; j++) {
				if(min > arr[j]) {
					min = arr[j];
					index= j;
				}
			}
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		return arr;
	}
}
