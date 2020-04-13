// 백준9465: 스티커
package alg.bj.DP;
import java.util.*;

public class dp_12_9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int h = 0; h < t; h++) {
			int n = sc.nextInt();
			int[][] map = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int[][] dp = new int[n + 1][3];

			dp[0][0] = 0; // 없음
			dp[0][1] = map[0][0]; // 상
			dp[0][2] = map[1][0]; // 하

			for (int i = 1; i <= n; i++) {

				// 카드를 선택하지 않을 경우			=> 위, 아래 중 큰 카드 선택
				if (dp[i - 1][2] > dp[i - 1][1]) {
					dp[i][0] = dp[i - 1][2];
				} else {
					dp[i][0] = dp[i - 1][1];
				}

				// 이전에 아래 쪽 카드를 선택했을 경우	=>	위 쪽 카드 선택
				dp[i][1] = dp[i - 1][2] + map[0][i];
				// 이전에 윗 쪽 카드를 선택했을 경우	=>	아래 쪽 카드 선택
				dp[i][2] = dp[i - 1][1] + map[1][i];

				// 이전에 카드를 선택하지 않았을 경우	=>	비교
				if (dp[i - 1][0] + map[0][i] > dp[i][1]) {
					dp[i][1] = dp[i - 1][0] + map[0][i];
				}
				if (dp[i - 1][0] + map[1][i] > dp[i][2]) {
					dp[i][2] = dp[i - 1][0] + map[1][i];
				}
			}
			Arrays.sort(dp[n]);
			System.out.println(dp[n][dp[0].length - 1]);
		}
	}
}