package SortProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class C2752 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		SelectionSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void SelectionSort(int[] arr) {
		int min = 10000001;
		int idx = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					idx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
	}
}
