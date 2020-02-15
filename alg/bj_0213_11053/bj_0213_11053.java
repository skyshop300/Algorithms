package alg.bj_0213_11053;
import java.util.*;

public class bj_0213_11053 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		int[] dp = new int[n+1];	// 수열 갯수
		dp[1] = 1;

		for(int i = 1 ; i < n + 1; i++) {
			a[i] = sc.nextInt();
			for(int j = 0; j < i; j++) {

				if(a[i] > a[j] && dp[i] <= dp[j] ) {
					dp[i] = dp[j] + 1;
				} 
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[dp.length - 1]);
	}
}

/* 
반례1  : 
7 
1 4 5 2 3 4 5 
답: 5
반례2 : 
20
2 54 77 21 14 32 68 47 22 10 6 85 77 85 111 140 25 43 31 11
답: 
*/