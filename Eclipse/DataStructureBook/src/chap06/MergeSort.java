package chap06;

import Array.CArray;

public class MergeSort { // O(nlog(n)) // 병합정렬 
	// 정렬 속도가 비교적 일정하다. 최선 평균 최악 다 nlog(n) 임
	
	static int[] src = {4, 1, 2, 7, 3, 9, 10};
	static int[] tmp = new int[src.length];
	
	public static void main(String args[]) {
		mergeSort(0, src.length - 1);
		
		CArray.printAry(src);
	}
	
	public static void mergeSort(int start, int end) {
		if (start<end) {
			int mid = (start+end) / 2;
			
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			int p = start; 
			int q = mid + 1; 
			int idx = p; 
			
			while (p <= mid || q <= end) {
				
				if (q>end || (p<=mid && src[p] < src[q])) {
					tmp[idx++] = src[p++]; 
				} else { 
					tmp[idx++] = src[q++]; 
					}
				} for (int i=start;i<=end;i++) {
					src[i]=tmp[i]; 
					}
				} 
		}
}
