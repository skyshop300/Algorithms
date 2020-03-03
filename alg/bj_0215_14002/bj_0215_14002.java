package alg.bj_0215_14002;
import java.util.*;

public class bj_0215_14002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		int[] dp = new int[n+1];		// 수열의 갯수
		int[] beforeIndex = new int[n+1];
		int maxIndex = 1;
		for(int i = 1; i < n + 1; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 1; i < n + 1; i++) {
			dp[i] = 1;
			for(int j = 1; j < i + 1; j++) {
				if(dp[i] <= dp[j] && a[i] > a[j]) {
					dp[i] = dp[j] + 1;
					beforeIndex[i] = j;
					if(dp[maxIndex] < dp[i]) {
						maxIndex = i;
					}
				}
			}
		}
		
		int[] nums = new int[dp[maxIndex]];
		nums[0] = a[maxIndex];
		int beforeIndexTemp = beforeIndex[maxIndex];
		
		for(int i = 1; i < dp[maxIndex]; i++) {
			nums[i] = a[beforeIndexTemp];
			beforeIndexTemp = beforeIndex[beforeIndexTemp];
		}

		System.out.println(dp[maxIndex]);
		for(int i = dp[maxIndex] - 1; i >= 0; i--) {
			System.out.print(nums[i] + " ");
		}
	}	
}
