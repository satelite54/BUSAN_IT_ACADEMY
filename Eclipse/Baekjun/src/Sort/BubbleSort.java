package Sort;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntArrayUtil arrUtil = new IntArrayUtil();
		int arrLength = 300;
		int arrMaxValue = 300;
		int[] arr = new int[arrLength];
		arrUtil.generateIntArrayRandom(arr, arrMaxValue);
		arrUtil.printIntArray(arr);
		
		BubbleSort(arr);
		arrUtil.printIntArray(arr);
	}
	
	public static void BubbleSort(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
