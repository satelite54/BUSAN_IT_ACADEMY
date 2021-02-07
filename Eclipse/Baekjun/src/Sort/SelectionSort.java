package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SelectionSort {
	// 배열에서 가장 작은걸 선택해서 앞으로 보내고 싶다!
	
	// 특정한 알고리즘의 수행시간을 간략하게 표현한 것이 빅오 표기법이다.
	// 선택 정렬은 비효율적인 알고리즘
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
		// min은 최소값을 저장하기 위한 변수
		// index는 바꿀지점의 index를 저장하기 위한 변수
		for(i = 0; i < 10; i++) {
			min = 99999999;// 모든 원소들 보다 큰값;
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
