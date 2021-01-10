package Array;

import java.util.Random;

public class CArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5};
		int[] b = a.clone(); // 얕은 복사 값만 복사함
		nAryReversesort(a);
		printAry(a);
	}
	
	public static void printInt(int n) {
		System.out.printf("%d", n);
	}
	
	public static void printAry(int[] nAry) {
		System.out.printf("Ary : [");
		for(int i = 0; i < nAry.length; i++) {
			if(i == nAry.length - 1) {
				System.out.printf("%d]\n", nAry[i]);
			}
			else {
				System.out.printf("%d, ", nAry[i]);	
			}
		}
	}
	public static int nAryMaxOf(int[] nAry) {
		int max = nAry[0];
		
		for(int i = 1; i < nAry.length; i++) {
			if(nAry[i] > max)
				max = nAry[i];
		}
		return max;
	}
	public static int[] RandomInt(int[] nAry, int nMax) { // 랜덤 정수 값 반환
		Random rand = new Random();
		for(int i = 0; i < nAry.length; i++) {
			nAry[i] = rand.nextInt(nMax);
		}
		return nAry;
	}
	
	public static void nAryReversesort(int[] nAry) {
		for(int i = 0; i < nAry.length / 2; i++) {
			nAryswap(nAry, i, nAry.length - i - 1);
		}
	}
	
	public static void nAryswap(int[] nAry, int idx1, int idx2) {
		int temp = 0;
		temp = nAry[idx1];
		nAry[idx1] = nAry[idx2];
		nAry[idx2] = temp;
	}
}
