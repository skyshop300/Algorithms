package alg.bj_0213_11053;
import java.util.*;

// 20
// 2 54 77 21 14 32 68 47 22 10 6 85 77 85 111 140 25 43 31 11
public class bj_0213_11053 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		int[] dp = new int[n+1];
		int maxDp = 0;
		for(int i = 1 ; i < n+1; i++) {
			a[i] = sc.nextInt();
			for(int j = 0; j < i + 1; j++) {
				if(a[i] > a[j]) {
					dp[i] = dp[j] + 1;
				} else {

				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[dp.length - 1]);
	}
}