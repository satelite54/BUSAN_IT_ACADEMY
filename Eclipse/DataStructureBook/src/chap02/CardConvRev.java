package chap02;

import java.util.Scanner;

public class CardConvRev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int no; // ��ȯ�ϴ� ����
		int cd; // ���
		int dno; // ��ȯ ���� �ڸ���
		int retry; // �ٽ� �ѹ�?
		char[] cno = new char[32];// ��ȯ �� ������ ���ڸ� ���� �δ� ������ �迭
		
		System.out.println("10������ ��� ��ȯ�մϴ�.");
		
		do {
			do {
				System.out.print("��ȯ�ϴ� ���� �ƴ� ���� : ");
				no = kb.nextInt();
			} while (no < 0);
			
			do {
				System.out.print("� ������ ��ȯ�ұ��? (2~36) :");
				cd = kb.nextInt();
			} while (cd < 2 || cd > 36);
			dno = cardConvR(no, cd ,cno);
			
			System.out.println(cd + "�����δ� ");
			for(int i = dno - 1; i >= 0; i--)
				System.out.print(cno[i]);
			System.out.println("�Դϴ�.");
			System.out.print("�� �� �� �ұ��? (1.��/0.�ƴϿ�) :");
			retry = kb.nextInt();
		} while (retry == 1);
	}
	
	static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);
			return digits;
	}
}
