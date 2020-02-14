package alg.bj_0213_11053;
import java.util.*;

// 20
// 2 54 77 21 14 32 68 47 22 10 6 85 77 85 111 140 25 43 31 11
public class bj_0213_11053 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		int[] dp = new int[n+1];	// 수열 갯수

		dp[1] = 1;

		for(int i = 1 ; i < n + 1; i++) {
			a[i] = sc.nextInt();
			int max = 0;
			int maxDp = 0;
			for(int j = 0; j < i; j++) {
				System.out.println("j" + j);
				System.out.println("a[i]" + a[i]);
				System.out.println("a[j]" + a[j]);
				System.out.println("max" + max);
				if(a[i] > a[j] && max < a[j] ) {
					max = a[j];
					dp[i] = dp[j] + 1;
					System.out.println("j: " + j);
					System.out.println("dp[j]: " + dp[j]);
					System.out.println("i: " + i);
					System.out.println("dp[i]: " + dp[i]);
					System.out.println();
				} 
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[dp.length - 1]);
	}
}

/* 7 
1 4 5 2 3 4 5 */