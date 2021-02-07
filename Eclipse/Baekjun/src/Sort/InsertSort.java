package Sort;

public class InsertSort { // 
	// 특정한 위치에서 
	int i, j, temp;
	public static void main(String[] args) {
		int[] arr = new int[10];
		IntArrayUtil.generateIntArrayRandom(arr, 10);
		IntArrayUtil.printIntArray(arr);
		int j = 0, temp = 0;
		for(int i = 1; i < 9; i++) {
			j = i;
			while(arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				j--;
			}
		}
		
		for(int i = 0; i< 10; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
