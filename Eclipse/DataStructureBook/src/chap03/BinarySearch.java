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
		//Arrays 클래스의 이진탐색 메소드
		System.out.println(result1);
		System.out.println(result2);
	}

	public static int BnSearch(int ar[], int len, int target){
		// 이진 탐색 알고리즘 반복문 구현
		// 찾는 숫자가 있으면 찾는 숫자의 인덱스 리턴 없으면 -1 리턴

	    int firstidx = 0;
	    int lastidx = len - 1;
	    int mididx = 0;
	    // first와 last가 같은 경우까지 반복하는 이유
	    // while(first < last)이면 마지막 하나가 남았을때
	    // 검사하지 않고 종료되기 때문이다.
	    while (firstidx <= lastidx){
	        mididx = (firstidx + lastidx) / 2; // 중앙 요소의 인덱스
	        if (ar[mididx] == target){ // 찾는 값이랑 중앙 요소의 값이 값으면
	            return mididx; // 중앙 요소 인덱스 리턴
	        }
	        else{
	            if (ar[mididx] > target) // 중앙 요소의 값보다 타겟 값이 작으면
	                lastidx = mididx - 1; // 검색 범위를 뒤쪽 반으로 줄인다.
	            else if(ar[mididx] <= target)
	                firstidx = mididx + 1; // 검색 범위를 앞쪽 반으로 줄인다.
	        } 
	    }
	    return -1;
	}
}
