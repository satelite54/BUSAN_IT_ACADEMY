package chap06;

public class QuickSort {

	void myQuickSort(int[] arr, int start, int end){
	    int pivot = arr[start];
	    int left = start + 1;
	    int right = end;
	 
	    while(left <= right){
	 
	        while(arr[left] < pivot){ left++; } //pivot보다 작은 경우는 건너뛰고 크거나 같은경우 멈춤
	        while(arr[right] > pivot) { right--; } //pivot보다 큰 경우는 건너뛰고 작거나 같은경우 멈춤
	 
	        if(left <= right){ swap(arr, left, right); }
	    }
	 
	 
	    if(start < end){  //1개로 쪼개질때 까지
	        swap(arr, start, right);   //pivot값과 arr[right] 값 swap
	 
	        myQuickSort(arr, start, right-1);  //앞 부분
	        myQuickSort(arr, right+1, end);    //뒷 부분
	    }
	 
	    return;
	}
	
	void swap(int[] arr,int a, int b){
	    int tmp = arr[a];
	    arr[a] = arr[b];
	    arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] nAry = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; 
	}

}
