import java.util.Scanner;

public class code11 {

//	중복된 정수쌍 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.print("배열의 수를 입력해 주세요. 배열의 수 : ");
		int nInput = kb.nextInt();
		
		int[] nAry = new int[nInput];
		for(int i = 0; i < nInput; i++) {
			System.out.print("배열 요소 입력");
			nAry[i] = kb.nextInt();
		}
		kb.close();
		for(int i = 0; i < nInput - 1; i++) {
			for(int j = i+1; j < nInput; j++) {
				if(nAry[i] == nAry[j]) {
					System.out.println("(" + nAry[i] + "," + nAry[j] + ")");
				}
			}
		}
	}
}
