package Dynamic;

import java.util.Scanner;

public class C11052 {

	public static void main(String[] args) {
//		민규가 구매하려고 하는 카드의 개수 N = 4
//		P1 = 1, P2 = 5, P3 = 6, P4 = 7
		
//		만약 민규가 카드 2개를 갖는다고 한다면
//		2개가 들어있는 카드팩 1개를 사던가, 1개짜리 카드팩 2개를 사는 경우이다.
//		지불 금액의 최댓값을 구해야하기 때문에
//		dp[2] = MAX(P[2], dp[1] + dp[1])이다.
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

        System.out.println(dp[N]); // dp[n] n개의 카드를 갖기 위해 지불하는 금액의 최대값
        //https://bellog.tistory.com/94
	}
}
