package alg.DP;
import java.util.*;

public class dp_10_11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();				// 자릿수
		int[][] d = new int[n+1][10];		// [자릿수][현 자릿수의 수]

		for(int i = 0; i < 10; i++) {
			d[1][i] = 1;
		}

		for(int i = 2; i < n+1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++) {
					d[i][j] = (d[i][j] + d[i-1][j-k]) % 10007;
					
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < 10; i++) {
			answer = (answer + d[n][i]) % 10007;
		}
		System.out.println(answer);
	}
}