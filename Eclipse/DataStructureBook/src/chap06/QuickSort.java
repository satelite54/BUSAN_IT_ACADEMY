package chap06;

public class QuickSort {

	void myQuickSort(int[] arr, int start, int end){
	    int pivot = arr[start];
	    int left = start + 1;
	    int right = end;
	 
	    while(left <= right){
	 
	        while(arr[left] < pivot){ left++; } //pivot���� ���� ���� �ǳʶٰ� ũ�ų� ������� ����
	        while(arr[right] > pivot) { right--; } //pivot���� ū ���� �ǳʶٰ� �۰ų� ������� ����
	 
	        if(left <= right){ swap(arr, left, right); }
	    }
	 
	 
	    if(start < end){  //1���� �ɰ����� ����
	        swap(arr, start, right);   //pivot���� arr[right] �� swap
	 
	        myQuickSort(arr, start, right-1);  //�� �κ�
	        myQuickSort(arr, right+1, end);    //�� �κ�
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
