import java.util.Scanner;

public class code11 {

//	�ߺ��� ������ ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.print("�迭�� ���� �Է��� �ּ���. �迭�� �� : ");
		int nInput = kb.nextInt();
		
		int[] nAry = new int[nInput];
		for(int i = 0; i < nInput; i++) {
			System.out.print("�迭 ��� �Է�");
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
