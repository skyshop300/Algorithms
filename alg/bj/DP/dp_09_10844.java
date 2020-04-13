// 백준10844: 
package alg.bj.DP;
import java.util.*;
// DFS로도 풀어보자.

public class dp_09_10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[101][10];
		int answer = 0;
		// DP로 해결

		for(int i = 1; i <= 9; i++) {
			d[1][i] = 1;
		}

		for(int i = 2; i <= n; i++) {
			d[i][0] = d[i-1][1];
			d[i][9] = d[i-1][8];
			for(int j = 1; j <= 8; j++) {
				d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % 1000000000;
			}
		}
		for(int i = 0; i < 10; i++) {
			answer = (answer + d[n][i]) % 1000000000;
		}
		System.out.println(answer);
	}
}