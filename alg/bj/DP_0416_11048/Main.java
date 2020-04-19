package alg.bj.DP_0416_11048;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][M+1];
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < M + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Solution sol = new Solution();
		sol.solution(N, M, map);
	}	
}
class Solution {
	public void solution(int N, int M, int[][] map) {
		int[][] candyMap = new int[N+1][M+1];
		int[] compare = new int[3];
		for(int i= 1; i < N + 1; i++) {
			for(int j = 1; j < M + 1; j++) {
				compare[0] = candyMap[i-1][j-1];
				compare[1] = candyMap[i-1][j];
				compare[2] = candyMap[i][j-1];
				Arrays.sort(compare);
				candyMap[i][j] = compare[2] + map[i][j];
			}
		}
		System.out.println(candyMap[N][M]);
	}
}