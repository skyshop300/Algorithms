// 백준2156: 포도주 시식
package alg.DP;
import java.util.*;
public class dp_0211_13_2156 {
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] glasses = new int[n+1];
		int[][] dp = new int[n+1][3];	// 0 : 안 먹음 // 1: 1번 먹음 // 2: 2번 먹음
	
		for(int i = 1; i < n+1; i++) {
			glasses[i] = sc.nextInt();
		}

		dp[1][0] = 0;
		dp[1][1] = glasses[1];
		
		for(int i = 2; i < n + 1; i++) {
			dp[i][1] = dp[i-1][0] + glasses[i];
			dp[i][2] = dp[i-1][1] + glasses[i];
			Arrays.sort(dp[i-1]);	// 안 마실 경우는 가장 큰놈을 고른다.
			dp[i][0] = dp[i-1][2];	// 직전에 안마신 경우가 가장 클 수도 있다.
			// 안 마실 경우가 제일 중요하다.
		}
		Arrays.sort(dp[n]);
		System.out.println(dp[n][2]);
	}
}

// 반례
// 7
// 6 2 0 1 7 2 0
// => 정답: 17