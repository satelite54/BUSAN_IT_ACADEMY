package Dynamic;

import java.util.Scanner;

public class C11052 {

	public static void main(String[] args) {
//		�α԰� �����Ϸ��� �ϴ� ī���� ���� N = 4
//		P1 = 1, P2 = 5, P3 = 6, P4 = 7
		
//		���� �α԰� ī�� 2���� ���´ٰ� �Ѵٸ�
//		2���� ����ִ� ī���� 1���� �����, 1��¥�� ī���� 2���� ��� ����̴�.
//		���� �ݾ��� �ִ��� ���ؾ��ϱ� ������
//		dp[2] = MAX(P[2], dp[1] + dp[1])�̴�.
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            P[i] = scanner.nextInt();
        }

        int[] dp = new int[N + 1];

        dp[1] = P[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = P[i];

            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[N]); // dp[n] n���� ī�带 ���� ���� �����ϴ� �ݾ��� �ִ밪
        //https://bellog.tistory.com/94
	}
}
