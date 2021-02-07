package Sort;

import java.util.Random;

public class IntArrayUtil {
	public static int[] generateIntArrayRandom(int[] arr, int maxValue) {
		Random rd = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(maxValue);
		}
		return arr;
	}
	
	public static void printIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
